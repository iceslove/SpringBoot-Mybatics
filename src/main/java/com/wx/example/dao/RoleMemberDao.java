package com.wx.example.dao;

import com.wx.example.dto.RoleMemberDetailDto;
import com.wx.example.entity.RoleMember;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleMemberDao {
	
	List<RoleMemberDetailDto> queryRoleMemberByPage(Map<String, Object> map);
	
	void insertRoleMember(RoleMember roleMember) throws Exception;

	@Select(" select count(0) from s_role_member where s_role_id=#{roleId} and sys_account_id=#{accountId} ")
	int getRoleMember(@Param(value = "roleId") int roleId, @Param(value = "accountId") int accountId) throws Exception;

	@Delete(" delete from s_role_member where s_role_id=#{roleId} and sys_account_id = #{accountId} ")
	void deleteRoleMember(@Param(value = "roleId") int roleId, @Param(value = "accountId") int accountId) throws Exception;

	@Delete(" delete from s_role_member where s_role_id=#{roleId} ")
	void deleteRoleMemberByRoleId(@Param(value = "roleId") int roleId) throws Exception;

}