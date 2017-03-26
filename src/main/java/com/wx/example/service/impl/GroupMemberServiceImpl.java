package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.service.BaseService;
import com.wx.example.service.GroupMemberService;
import com.wx.example.common.entity.PageBean;
import com.wx.example.dao.GroupMemberDao;
import com.wx.example.dto.GroupMemberDetailDto;
import com.wx.example.entity.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * Created by wangxiong on 2017/3/18.
 */

@Service
@Transactional
public class GroupMemberServiceImpl extends BaseService implements GroupMemberService {

	@Autowired
	private GroupMemberDao groupMemberDao;

	@Override
	public void insertGroupMember(int groupId, String accountIdStr) throws Exception {

		GroupMember groupMember = new GroupMember();
		groupMember.setGroupId(groupId);

		String[] accountIds = accountIdStr.split("_");
		for (String accountId :accountIds ) {

			int count = groupMemberDao.getGroupMember(groupId,Integer.parseInt(accountId));
			if(count>0){
				continue;
			}
			groupMember.setAccountId(Integer.parseInt(accountId));
			groupMemberDao.insertGroupMember(groupMember);
		}

	}

	@Override
	public void deleteGroupMember(int groupId, int accountId) throws Exception{
		this.groupMemberDao.deleteGroupMember(groupId, accountId);
	}

	@Override
	public PageBean<GroupMemberDetailDto> queryGroupMemberByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<GroupMemberDetailDto> list = this.groupMemberDao.queryGroupMemberByPage(map);

		PageBean<GroupMemberDetailDto> page = new PageBean<>(list);

		return page;
	}

}
