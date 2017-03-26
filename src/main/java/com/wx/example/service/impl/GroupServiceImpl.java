package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.service.BaseService;
import com.wx.example.dao.GroupDao;
import com.wx.example.dao.IntKeyDao;
import com.wx.example.entity.Group;
import com.wx.example.service.GroupService;
import com.wx.example.dto.GroupDetailDto;
import com.wx.example.dto.TreeDto;
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
public class GroupServiceImpl extends BaseService implements GroupService {

	private static final String TABLE_NAME = "s_group" ;

	@Autowired
	private GroupDao groupDao;

	@Autowired
	public void setIntKeyDao(IntKeyDao intKeyDao) {
		super.setIntKeyDao(intKeyDao);
	}

	@Override
	public GroupDetailDto getGroupById(int groupId) {
		return this.groupDao.getGroupById(groupId);
	}

	@Override
	public void insertGroup(Group group) throws Exception {

		Group groupParentInfo = groupDao.getGroupById(group.getGroupParent());

		int groupRight = groupParentInfo.getGroupRight() ;
		int groupLeft  = groupParentInfo.getGroupLeft() ;

		groupDao.increment( "s_group_right", 2, " s_group_right >= " + groupRight );

		groupDao.increment( "s_group_right", 2, " s_group_left >= " + groupRight );

		int groupId = getPrimaryKey(TABLE_NAME);

		Group insertGroup = new Group();
		insertGroup.setGroupId(groupId);
		insertGroup.setGroupName(group.getGroupName());
		insertGroup.setGroupType(group.getGroupType());
		insertGroup.setGroupLeft(groupParentInfo.getGroupRight());
		insertGroup.setGroupRight(groupParentInfo.getGroupRight()+1);
		insertGroup.setGroupParent(group.getGroupParent());
		insertGroup.setGroupLevel(groupParentInfo.getGroupLevel()+1);
		insertGroup.setGroupLeaf(1);
		insertGroup.setGroupDesc(group.getGroupDesc());

		groupDao.insertGroup(insertGroup);

		groupDao.updateGroupLeaf(group.getGroupParent(), 0);

	}

	@Override
	public void updateGroup(Group group) throws Exception{
		this.groupDao.updateGroup(group);
	}

	@Override
	public void deleteGroup(int groupId) throws Exception{

		Group groupInfo = groupDao.getGroupById(groupId);

		int groupRight = groupInfo.getGroupRight() ;
		int groupLeft  = groupInfo.getGroupLeft() ;

		groupDao.deleteGroup(" s_group_left >= "+groupLeft+" and s_group_right <= "+groupRight);

		int steps = groupRight - groupLeft + 1 ;
		groupDao.decrement("s_group_left", steps, "s_group_left > "+groupLeft);

		groupDao.decrement("s_group_right", steps, "s_group_right > "+groupRight);

		int count = groupDao.countByGroupParent(groupInfo.getGroupParent());
		if(count < 1){
			groupDao.updateGroupLeaf(groupInfo.getGroupParent(),1);
		}

	}

	@Override
	public PageBean<Group> queryGroupByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<Group> list = groupDao.queryGroupByPage(map);

		PageBean<Group> page = new PageBean<>(list);

		return page;
	}

	@Override
	public List<Group> getGroupByParent(int groupParent) {
		return this.groupDao.getGroupByParent(groupParent);
	}

	@Override
	public List<TreeDto> getGroupList(int groupParent) {

		List<TreeDto> treeList = new ArrayList<>();

		List<Group> list = groupDao.getGroupByParent(groupParent);

		for (Group group: list) {
			Map map = new HashMap();
			map.put("opened",true);

			TreeDto dto = new TreeDto();
			dto.setId(group.getGroupId());
			dto.setText(group.getGroupName());
			dto.setState(map);
			dto.setChildren(this.getGroupList(group.getGroupId()));

			treeList.add(dto);
		}

		return treeList;
	}
}
