package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.entity.Group;
import com.wx.example.dto.GroupDetailDto;
import com.wx.example.dto.TreeDto;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface GroupService {

	PageBean<Group> queryGroupByPage(Map<String, Object> map);

	GroupDetailDto getGroupById(int groupId);

	List<Group> getGroupByParent(int groupParent);

	List<TreeDto> getGroupList(int groupParent) ;

	void insertGroup(Group group) throws Exception;

	void updateGroup(Group group) throws Exception;

	void deleteGroup(int groupId) throws Exception;

}
