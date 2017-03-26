package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class MemberGrant implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer accountId;

    private Integer groupGrant;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getGroupGrant() {
        return groupGrant;
    }

    public void setGroupGrant(Integer groupGrant) {
        this.groupGrant = groupGrant;
    }
}
