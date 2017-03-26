package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class Group implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer groupId;

    private String groupName;

    private Integer groupType;

    private Integer groupLeft;

    private Integer groupRight;

    private Integer groupParent;

    private Integer groupLevel;

    private Integer groupLeaf;

    private String groupDesc;

    private String createTime;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public Integer getGroupLeft() {
        return groupLeft;
    }

    public void setGroupLeft(Integer groupLeft) {
        this.groupLeft = groupLeft;
    }

    public Integer getGroupRight() {
        return groupRight;
    }

    public void setGroupRight(Integer groupRight) {
        this.groupRight = groupRight;
    }

    public Integer getGroupParent() {
        return groupParent;
    }

    public void setGroupParent(Integer groupParent) {
        this.groupParent = groupParent;
    }

    public Integer getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(Integer groupLevel) {
        this.groupLevel = groupLevel;
    }

    public Integer getGroupLeaf() {
        return groupLeaf;
    }

    public void setGroupLeaf(Integer groupLeaf) {
        this.groupLeaf = groupLeaf;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
