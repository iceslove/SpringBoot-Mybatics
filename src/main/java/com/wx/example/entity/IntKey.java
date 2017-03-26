package com.wx.example.entity;

import java.io.Serializable;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class IntKey implements Serializable {
    private static final long serialVersionUID = 3265524976080127173L;

    private String keyName ; //数据库表名字

    private Integer keyValue ; //当前最大id

    public IntKey() {
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(Integer keyValue) {
        this.keyValue = keyValue;
    }
}
