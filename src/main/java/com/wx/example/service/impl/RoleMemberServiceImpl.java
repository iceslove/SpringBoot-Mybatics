package com.wx.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.wx.example.common.service.BaseService;
import com.wx.example.dao.RoleMemberDao;
import com.wx.example.service.RoleMemberService;
import com.wx.example.common.entity.PageBean;
import com.wx.example.dto.RoleMemberDetailDto;
import com.wx.example.entity.RoleMember;
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
public class RoleMemberServiceImpl extends BaseService implements RoleMemberService {

	@Autowired
	private RoleMemberDao roleMemberDao;

	@Override
	public void insertRoleMember(int roleId, String accountIdStr) throws Exception {

		//roleMemberDao.deleteRoleMemberByRoleId(roleId);

		RoleMember roleMember = new RoleMember();
		roleMember.setRoleId(roleId);

		String[] accountIds = accountIdStr.split("_");
		for (String accountId :accountIds ) {

			int count = roleMemberDao.getRoleMember(roleId,Integer.parseInt(accountId));
			if(count>0){
				continue;
			}
			roleMember.setAccountId(Integer.parseInt(accountId));
			roleMemberDao.insertRoleMember(roleMember);
		}

	}

	@Override
	public void deleteRoleMember(int roleId, int accountId) throws Exception{
		this.roleMemberDao.deleteRoleMember(roleId, accountId);
	}

	@Override
	public PageBean<RoleMemberDetailDto> queryRoleMemberByPage(Map<String,Object> map) {

		int pageNum = (Integer) map.get("pageNum");
		int pageSize = (Integer) map.get("pageSize");

		PageHelper.startPage(pageNum,pageSize);
		List<RoleMemberDetailDto> list = this.roleMemberDao.queryRoleMemberByPage(map);

		PageBean<RoleMemberDetailDto> page = new PageBean<>(list);

		return page;
	}

}
