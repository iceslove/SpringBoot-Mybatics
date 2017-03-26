package com.wx.example.dto;

import com.wx.example.entity.Group;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class GroupDetailDto extends Group implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private String groupParentName;

    private String groupTypeName;

    public String getGroupParentName() {
        return groupParentName;
    }

    public void setGroupParentName(String groupParentName) {
        this.groupParentName = groupParentName;
    }

    public String getGroupTypeName() {
        return groupTypeName;
    }

    public void setGroupTypeName(String groupTypeName) {
        this.groupTypeName = groupTypeName;
    }
}
