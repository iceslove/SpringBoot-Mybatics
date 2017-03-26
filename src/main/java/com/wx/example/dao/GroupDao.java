package com.wx.example.dao;

import com.wx.example.entity.Group;
import com.wx.example.dto.GroupDetailDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface GroupDao {

	GroupDetailDto getGroupById(int groupId);
	
	List<Group> queryGroupByPage(Map<String, Object> map);

	List<Group> getGroupByParent(int groupParent);
	
	void insertGroup(Group group) throws Exception;
    
	void updateGroup(Group group) throws Exception;
	
	@Delete("delete from s_group WHERE ${condition}")
	void deleteGroup(@Param(value = "condition") String condition);

	@Update("UPDATE s_group SET ${params} = ${params} + #{steps} WHERE ${condition}")
	void increment(@Param(value = "params") String params, @Param(value = "steps") int steps, @Param(value = "condition") String condition);

	@Update("UPDATE s_group SET ${params} = ${params} - #{steps} WHERE ${condition}")
	void decrement(@Param(value = "params") String params, @Param(value = "steps") int steps, @Param(value = "condition") String condition);

	@Update("UPDATE s_group SET s_group_leaf = #{status} WHERE s_group_id = #{groupId}")
	void updateGroupLeaf(@Param(value = "groupId") int groupId, @Param(value = "status") int status);

	@Select("SELECT count(0) from s_group WHERE s_group_parent = #{groupParent}")
	int countByGroupParent(int groupParent);
	
}