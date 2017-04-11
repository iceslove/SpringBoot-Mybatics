package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.dto.PageResult;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.exception.CustomException;
import com.wx.example.dto.GroupMemberDetailDto;
import com.wx.example.dto.TreeDto;
import com.wx.example.service.GroupMemberService;
import com.wx.example.service.MemberGrantService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/groupMember")
public class GroupMemberController extends BaseController {

    @Autowired
    private GroupMemberService groupMemberService;

    @Autowired
    private MemberGrantService memberGrantService;

    @RequestMapping(value="",method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("groupMember/index");
        return modal;
    }

    @RequestMapping(value="/query",method=RequestMethod.POST)
    @ResponseBody
    public PageResult queryGroupMember(HttpServletRequest request){

        Map<String,Object> map = buildSearchParam(request);
        String groupId = request.getParameter("groupId") ;
        if(StringUtils.isNotEmpty(groupId)){
            map.put("groupId",groupId);
        }
        PageBean<GroupMemberDetailDto> pageInfo = groupMemberService.queryGroupMemberByPage(map);

        return showPageResult(pageInfo);
    }

    @RequestMapping(value="/add",method=RequestMethod.GET)
    public ModelAndView addGroupMember(){
        ModelAndView model = new ModelAndView("groupMember/selectAccount");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertGroupMember(HttpServletRequest request) throws CustomException {

        try {
            int groupId = Integer.parseInt(request.getParameter("groupId"));
            String accountIdStr = request.getParameter("accountIdStr");

            groupMemberService.insertGroupMember(groupId,accountIdStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"保存成功",null) ;
    }

    @RequestMapping(value="/delete/{groupId}/{accountId}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteGroupMember(@PathVariable int groupId, @PathVariable int accountId) throws CustomException{

        try {
            groupMemberService.deleteGroupMember(groupId, accountId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"删除成功",null) ;
    }

    @RequestMapping(value="selectGroup/{accountId}", method=RequestMethod.GET)
    public ModelAndView selectGroup(@PathVariable int accountId){

        ModelAndView modal = new ModelAndView("groupMember/selectGroup");
        modal.addObject("groupId",accountId) ;

        return modal;
    }

    @RequestMapping(value="/getSelectedGroupTree/{accountId}",method=RequestMethod.GET)
    @ResponseBody
    public List getSelectedGroupTree(@PathVariable int accountId){
        List<TreeDto> roleTree = memberGrantService.getSelectedGroupTree(accountId,0);
        return roleTree;
    }

    @RequestMapping(value="saveGroupGrant", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult saveGroupGrant(HttpServletRequest request) throws CustomException{

        int accountId = Integer.parseInt(request.getParameter("accountId"));
        String selectedNodes = request.getParameter("selectedNodes") ;

        try {
            memberGrantService.saveMemberGrant(accountId,selectedNodes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getClass().toString());
        }
        return showJsonResult(true,"保存成功",null) ;
    }

}
