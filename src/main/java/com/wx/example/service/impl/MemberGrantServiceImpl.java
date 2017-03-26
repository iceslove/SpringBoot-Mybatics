package com.wx.example.service.impl;

import com.wx.example.common.service.BaseService;
import com.wx.example.dao.GroupDao;
import com.wx.example.dao.MemberGrantDao;
import com.wx.example.dto.TreeDto;
import com.wx.example.entity.Group;
import com.wx.example.entity.MemberGrant;
import com.wx.example.service.MemberGrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Service
@Transactional
public class MemberGrantServiceImpl extends BaseService implements MemberGrantService {

	@Autowired
	private MemberGrantDao memberGrantDao;

	@Autowired
	private GroupDao groupDao;

	@Override
	public void saveMemberGrant(int accountId, String groupIdStr) throws Exception {
		memberGrantDao.deleteMemberGrant(accountId);

		MemberGrant item = new MemberGrant();
		item.setAccountId(accountId);

		String[] groupIds = groupIdStr.split("@@");

		for (String groupId :groupIds ) {
			item.setGroupGrant(Integer.parseInt(groupId));
			memberGrantDao.insertMemberGrant(item);
		}
	}

	@Override
	public List<TreeDto> getSelectedGroupTree(int accountId, int groupParent) {

		List<MemberGrant> list = memberGrantDao.getMemberGrantByAccountId(accountId);

		List<TreeDto> treeList = this.getGroupList(list,0);

		return treeList;
	}

	private List<TreeDto> getGroupList(List<MemberGrant> grantList, int groupParent) {

		List<TreeDto> treeList = new ArrayList<>();
		List<Group> list = groupDao.getGroupByParent(groupParent);

		for (Group group: list) {

			boolean selected = false;
			for (MemberGrant memberGrant: grantList) {
				if(memberGrant.getGroupGrant() == group.getGroupId()){
					selected = true ;
				}
			}

			Map map = new HashMap();
			map.put("opened",true);
			map.put("selected",selected);

			TreeDto item = new TreeDto();
			item.setId(group.getGroupId());
			item.setText(group.getGroupName());
			item.setState(map);
			item.setChildren(this.getGroupList(grantList,group.getGroupId()));

			treeList.add(item);
		}

		return treeList;
	}
}
