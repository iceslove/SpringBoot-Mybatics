package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class GroupMember implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer groupId;

    private Integer accountId;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
