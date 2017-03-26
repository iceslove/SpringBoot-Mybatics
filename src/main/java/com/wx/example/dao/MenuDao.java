package com.wx.example.dao;

import com.wx.example.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface MenuDao {
	
	Menu getMenuById(int menuId);

	List<Menu> getMenuByParent(int menuParent);

	List<Menu> getFirstMenu();

	List<Menu> queryMenuByPage(Map<String, Object> map);
	
	void insertMenu(Menu menu) throws Exception;
    
	void updateMenu(Menu menu) throws Exception;
	
	void deleteMenu(int menuId) throws Exception;
	
}