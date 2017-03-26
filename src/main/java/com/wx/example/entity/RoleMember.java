package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class RoleMember implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer roleId;

    private Integer accountId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
