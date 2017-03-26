package com.wx.example.dao;

import com.wx.example.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface AccountDao {
	
	Account getAccountById(int accountId);
	
	Account getAccountByName(String accountName);
	
	List<Account> queryAccountByPage(Map<String, Object> map);
	
	void insertAccount(Account account) throws Exception;
    
	void updateAccount(Account account) throws Exception;
	
	void deleteAccount(int accountId) throws Exception;

	void updatePassword(@Param(value = "accountId") int accountId, @Param(value = "password") String password) throws Exception;

}