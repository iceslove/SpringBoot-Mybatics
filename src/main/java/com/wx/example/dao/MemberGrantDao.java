package com.wx.example.dao;

import com.wx.example.entity.MemberGrant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface MemberGrantDao {

	@Insert("INSERT INTO s_member_grant(sys_account_id, s_group_grant) VALUES(#{accountId}, #{groupGrant})")
	void insertMemberGrant(MemberGrant memberGrant) throws Exception;

	@Delete(" delete from s_member_grant where sys_account_id = #{accountId} ")
	void deleteMemberGrant(@Param(value = "accountId") int accountId) throws Exception;

	@Select(" select sys_account_id as accountId, s_group_grant as groupGrant from s_member_grant where sys_account_id = #{accountId} ")
	List<MemberGrant> getMemberGrantByAccountId(@Param(value = "accountId") int accountId);

}