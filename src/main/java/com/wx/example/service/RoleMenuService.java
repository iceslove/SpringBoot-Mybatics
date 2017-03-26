package com.wx.example.service;

import com.wx.example.entity.RoleMenu;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleMenuService {

	void insertRoleMenu(RoleMenu roleMenu) throws Exception;

	void deleteRoleMenu(int roleMenuId) throws Exception;

	void saveRoleMenu(int roleId, String[] menuIds) throws Exception ;

}
