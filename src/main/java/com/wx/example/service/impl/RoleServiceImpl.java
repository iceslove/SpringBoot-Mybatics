package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.service.BaseService;
import com.wx.example.dao.IntKeyDao;
import com.wx.example.dao.RoleDao;
import com.wx.example.entity.Menu;
import com.wx.example.service.RoleService;
import com.wx.example.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Created by wangxiong on 2017/3/18.
 */

@Service
@Transactional
public class RoleServiceImpl extends BaseService implements RoleService {

	private static final String TABLE_NAME = "s_role" ;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	public void setIntKeyDao(IntKeyDao intKeyDao) {
		super.setIntKeyDao(intKeyDao);
	}

	@Override
	public Role getRoleById(int RoleId) {
		return this.roleDao.getRoleById(RoleId);
	}

	@Override
	public void insertRole(Role Role) throws Exception {

		int primaryKey = getPrimaryKey(TABLE_NAME);

		Role.setRoleId(primaryKey);
		this.roleDao.insertRole(Role);

	}

	@Override
	public void updateRole(Role Role) throws Exception{
		this.roleDao.updateRole(Role);
	}

	@Override
	public void deleteRole(int RoleId) throws Exception{
		this.roleDao.deleteRole(RoleId);
	}

	@Override
	public PageBean<Role> queryRoleByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<Role> list = this.roleDao.queryRoleByPage(map);

		PageBean<Role> page = new PageBean<>(list);

		return page;
	}

	@Override
	public List<Role> getRoleList(){
		return this.roleDao.getRoleList();
	}

	@Override
	public List<Menu> getCheckedMenus(int roleId, int menuParent) {

		List<Menu> treeList = new ArrayList<>();

		List<Menu> list     = roleDao.getCheckedMenus(roleId,menuParent);
		for (Menu menu: list) {
			menu.setChildMenu(this.getCheckedMenus(roleId,menu.getMenuId()));
			treeList.add(menu);
		}

		return treeList;
	}

}
