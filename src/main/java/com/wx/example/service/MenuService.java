package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface MenuService {

	PageBean<Menu> queryMenuByPage(Map<String, Object> map);

	Menu getMenuById(int menuId);

	List<Menu> getMenuList(int menuParent) ;

	List<Menu> getFirstMenu() ;

	void insertMenu(Menu menu) throws Exception;

	void updateMenu(Menu menu) throws Exception;

	void deleteMenu(int menuId) throws Exception;

}
