package com.wx.example.dao;

import com.wx.example.entity.Menu;
import com.wx.example.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleDao {
	
	Role getRoleById(int roleId);
	
	List<Role> queryRoleByPage(Map<String, Object> map);

	List<Role> getRoleList();

	@Select("select a.menu_id as menuId, a.menu_text as menuText,a.menu_parent as menuParent, "+
			" a.menu_url as menuUrl, a.menu_css as menuCss,a.menu_order as menuOrder, "+
			" b.s_role_id as hasChecked from menu as a left join s_role_menu as b "+
			" on ( a.menu_id = b.menu_id and b.s_role_id = #{roleId} ) where a.menu_parent=#{parentId}")
	List<Menu> getCheckedMenus(@Param(value = "roleId") int roleId, @Param(value = "parentId") int parentId);
	
	void insertRole(Role role) throws Exception;
    
	void updateRole(Role role) throws Exception;
	
	void deleteRole(int roleId) throws Exception;
	
}