package com.wx.example.dao;

import com.wx.example.entity.RoleMenu;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleMenuDao {
	
	void insertRoleMenu(RoleMenu roleMenu) throws Exception;

	void deleteRoleMenu(int roleMenuId) throws Exception;
	
}