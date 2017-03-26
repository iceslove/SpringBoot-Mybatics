package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.dto.GroupMemberDetailDto;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface GroupMemberService {

	PageBean<GroupMemberDetailDto> queryGroupMemberByPage(Map<String, Object> map);

	void insertGroupMember(int groupId, String accountIdStr) throws Exception;

	void deleteGroupMember(int groupId, int accountId) throws Exception;

}
