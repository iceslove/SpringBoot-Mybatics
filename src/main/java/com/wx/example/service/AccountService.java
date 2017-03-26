package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.entity.Account;

import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface AccountService {

	PageBean<Account> queryAccountByPage(Map<String, Object> map);

	Account getAccountById(int accountId);

	Account getAccountByName(String accountName);

	void insertAccount(Account account) throws Exception;

	void updateAccount(Account account) throws Exception;

	void deleteAccount(int accountId) throws Exception;

	void updatePassword(int accountId, String password) throws Exception;

}
