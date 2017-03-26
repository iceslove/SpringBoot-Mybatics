package com.wx.example.dao;

import com.wx.example.entity.IntKey;

/**
 * Created by wangxiong on 2017/3/18.
 */

public interface IntKeyDao {

    IntKey getByKeyName(String keyName);

    void updateKeyValue(IntKey intKey);

}
