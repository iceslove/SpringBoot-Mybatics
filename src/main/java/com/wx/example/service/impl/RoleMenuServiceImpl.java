package com.wx.example.service.impl;

import com.wx.example.entity.RoleMenu;
import com.wx.example.common.service.BaseService;
import com.wx.example.service.RoleMenuService;
import com.wx.example.dao.RoleMenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by wangxiong on 2017/3/18.
 */

@Service
@Transactional
public class RoleMenuServiceImpl extends BaseService implements RoleMenuService {

	@Autowired
	private RoleMenuDao roleMenuDao;

	@Override
	public void insertRoleMenu(RoleMenu roleMenu) throws Exception {
		this.roleMenuDao.insertRoleMenu(roleMenu);
	}

	@Override
	public void deleteRoleMenu(int roleMenuId) throws Exception{
		this.roleMenuDao.deleteRoleMenu(roleMenuId);
	}

	@Override
	public void saveRoleMenu(int roleId, String[] menuIds) throws Exception {
		roleMenuDao.deleteRoleMenu(roleId);

		RoleMenu item = new RoleMenu();
		item.setRoleId(roleId);

		for (String menuId :menuIds ) {
			item.setMenuId(Integer.parseInt(menuId));
			roleMenuDao.insertRoleMenu(item);
		}
	}

}
