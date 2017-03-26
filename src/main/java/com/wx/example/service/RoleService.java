package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.entity.Menu;
import com.wx.example.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleService {

	PageBean<Role> queryRoleByPage(Map<String, Object> map);

	List<Role> getRoleList();

	List<Menu> getCheckedMenus(int roleId, int menuParent);

	Role getRoleById(int roleId);

	void insertRole(Role role) throws Exception;

	void updateRole(Role role) throws Exception;

	void deleteRole(int roleId) throws Exception;

}
