package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.dto.PageResult;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.exception.CustomException;
import com.wx.example.dto.RoleMemberDetailDto;
import com.wx.example.service.RoleMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/roleMember")
public class RoleMemberController extends BaseController {

    @Autowired
    private RoleMemberService roleMemberService;

    @RequestMapping(value="",method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("roleMember/index");
        return modal;
    }

    @RequestMapping(value="/query",method=RequestMethod.POST)
    @ResponseBody
    public PageResult queryRoleMember(HttpServletRequest request){

        Map<String,Object> map = buildSearchParam(request);
        String roleId = request.getParameter("roleId") ;
        if(StringUtils.isNotEmpty(roleId)){
            map.put("roleId",roleId);
        }
        PageBean<RoleMemberDetailDto> pageInfo = roleMemberService.queryRoleMemberByPage(map);

        return showPageResult(pageInfo);
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView addRoleMember(){
        ModelAndView model = new ModelAndView("roleMember/selectAccount");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertRoleMember(HttpServletRequest request) throws CustomException {
        try {
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            String accountIdStr = request.getParameter("accountIdStr");

            roleMemberService.insertRoleMember(roleId,accountIdStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"保存成功",null) ;
    }

    @RequestMapping(value="/delete/{roleId}/{accountId}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteRoleMember(@PathVariable int roleId, @PathVariable int accountId) throws CustomException{

        try {
            roleMemberService.deleteRoleMember(roleId, accountId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"删除成功",null) ;
    }


}
