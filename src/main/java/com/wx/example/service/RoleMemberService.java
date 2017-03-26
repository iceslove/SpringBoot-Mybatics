package com.wx.example.service;

import com.wx.example.common.entity.PageBean;
import com.wx.example.dto.RoleMemberDetailDto;

import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */
public interface RoleMemberService {

	PageBean<RoleMemberDetailDto> queryRoleMemberByPage(Map<String, Object> map);

	void insertRoleMember(int roleId, String accountIdStr) throws Exception;

	void deleteRoleMember(int roleId, int accountId) throws Exception;

}
