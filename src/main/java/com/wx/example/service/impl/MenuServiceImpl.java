package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.service.BaseService;
import com.wx.example.dao.IntKeyDao;
import com.wx.example.dao.MenuDao;
import com.wx.example.entity.Menu;
import com.wx.example.service.MenuService;
import com.wx.example.common.entity.PageBean;
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
public class MenuServiceImpl extends BaseService implements MenuService {

	private static final String TABLE_NAME = "menu" ;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	public void setIntKeyDao(IntKeyDao intKeyDao) {
		super.setIntKeyDao(intKeyDao);
	}

	@Override
	public Menu getMenuById(int MenuId) {
		return this.menuDao.getMenuById(MenuId);
	}

	@Override
	public void insertMenu(Menu Menu) throws Exception {

		int primaryKey = getPrimaryKey(TABLE_NAME);

		Menu.setMenuId(primaryKey);
		this.menuDao.insertMenu(Menu);

	}

	@Override
	public void updateMenu(Menu Menu) throws Exception{
		this.menuDao.updateMenu(Menu);
	}

	@Override
	public void deleteMenu(int MenuId) throws Exception{
		this.menuDao.deleteMenu(MenuId);
	}

	@Override
	public PageBean<Menu> queryMenuByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<Menu> list = menuDao.queryMenuByPage(map);

		PageBean<Menu> page = new PageBean<>(list);

		return page;
	}

	@Override
	public List<Menu> getMenuList(int menuParent) {

		List<Menu> treeList = new ArrayList<>();

		List<Menu> list = menuDao.getMenuByParent(menuParent);

		for (Menu menu: list) {
			menu.setChildMenu(this.getMenuList(menu.getMenuId()));
			treeList.add(menu);
		}

		return treeList;
	}

	@Override
	public List<Menu> getFirstMenu() {
		return menuDao.getFirstMenu();
	}
}
