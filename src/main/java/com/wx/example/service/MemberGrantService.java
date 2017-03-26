package com.wx.example.service;

import com.wx.example.dto.TreeDto;

import java.util.List;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface MemberGrantService {

	void saveMemberGrant(int accountId, String groupIds) throws Exception ;

	List<TreeDto> getSelectedGroupTree(int accountId, int groupParent) ;

}
