package com.wx.example.dto;

import com.wx.example.entity.RoleMember;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class RoleMemberDetailDto extends RoleMember implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private String roleName;

    private String accountName;

    private String accountRealName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountRealName() {
        return accountRealName;
    }

    public void setAccountRealName(String accountRealName) {
        this.accountRealName = accountRealName;
    }
}
