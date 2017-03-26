package com.wx.example.entity;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class Role implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private String roleSort;

    private Integer roleFixed;

    private String createTime;

    private Integer createBy;

    private String updateTime;

    private Integer updateBy;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public Integer getRoleFixed() {
        return roleFixed;
    }

    public void setRoleFixed(Integer roleFixed) {
        this.roleFixed = roleFixed;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}
