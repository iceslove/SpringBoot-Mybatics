package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.service.BaseService;
import com.wx.example.dao.AccountDao;
import com.wx.example.dao.IntKeyDao;
import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * Created by wangxiong on 2017/3/18.
 */

@Service
@Transactional
public class AccountServiceImpl extends BaseService implements AccountService {

	private static final String TABLE_NAME = "account" ;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	public void setIntKeyDao(IntKeyDao intKeyDao) {
		super.setIntKeyDao(intKeyDao);
	}

	@Override
	public Account getAccountById(int accountId) {
		return this.accountDao.getAccountById(accountId);
	}

	@Override
	public Account getAccountByName(String accountName) {
		return this.accountDao.getAccountByName(accountName);
	}

	@Override
	public void insertAccount(Account account) throws Exception {

		int primaryKey = getPrimaryKey(TABLE_NAME);

		account.setAccountId(primaryKey);
		this.accountDao.insertAccount(account);

	}

	@Override
	public void updateAccount(Account account) throws Exception{
		this.accountDao.updateAccount(account);
	}

	@Override
	public void deleteAccount(int accountId) throws Exception{
		this.accountDao.deleteAccount(accountId);
	}

	@Override
	public void updatePassword(int accountId, String password) throws Exception {
		this.accountDao.updatePassword(accountId, password);
	}

	@Override
	public PageBean<Account> queryAccountByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<Account> list = accountDao.queryAccountByPage(map);

		PageBean<Account> page = new PageBean<>(list);

		return page;
	}

}
