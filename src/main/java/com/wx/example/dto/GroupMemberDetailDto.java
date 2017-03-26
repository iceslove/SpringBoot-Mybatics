package com.wx.example.dto;

import com.wx.example.entity.GroupMember;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class GroupMemberDetailDto extends GroupMember implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private String groupName;

    private String accountName;

    private String accountRealName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
