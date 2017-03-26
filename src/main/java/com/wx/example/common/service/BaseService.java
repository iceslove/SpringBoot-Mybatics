package com.wx.example.common.service;

import com.wx.example.dao.IntKeyDao;
import com.wx.example.entity.IntKey;

/**
 * Created by wangxiong on 2017/3/18.
 */
public class BaseService {

	protected IntKeyDao intKeyDao;

	public void setIntKeyDao(IntKeyDao intKeyDao) {
		this.intKeyDao = intKeyDao;
	}

	public synchronized int getPrimaryKey(String keyName) {

		IntKey intKey = intKeyDao.getByKeyName(keyName);
		int value = intKey.getKeyValue()+1;
		intKey.setKeyValue(value);
		intKeyDao.updateKeyValue(intKey);

		return value;
	}

}
