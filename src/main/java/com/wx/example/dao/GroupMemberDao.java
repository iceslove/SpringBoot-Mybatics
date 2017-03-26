package com.wx.example.dao;

import com.wx.example.dto.GroupMemberDetailDto;
import com.wx.example.entity.GroupMember;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface GroupMemberDao {
	
	List<GroupMemberDetailDto> queryGroupMemberByPage(Map<String, Object> map);

	@Select(" select count(0) from s_group_member where s_group_id=#{groupId} and sys_account_id=#{accountId} ")
	int getGroupMember(@Param(value = "groupId") int groupId, @Param(value = "accountId") int accountId) throws Exception;

	void insertGroupMember(GroupMember groupMember) throws Exception;
    
	void deleteGroupMember(@Param(value = "groupId") int groupId, @Param(value = "accountId") int accountId) throws Exception;

}