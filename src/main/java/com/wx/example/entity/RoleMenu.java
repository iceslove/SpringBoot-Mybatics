package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class RoleMenu implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer roleId;

    private Integer menuId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
