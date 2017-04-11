package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.exception.CustomException;
import com.wx.example.common.utils.DateUtils;
import com.wx.example.dto.GroupDetailDto;
import com.wx.example.dto.TreeDto;
import com.wx.example.entity.Group;
import com.wx.example.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/group") // 通过这里配置使下面的映射都在/users下
public class GroupController extends BaseController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("group/index");
        return modal;
    }

//    @RequestMapping(value="/query",method=RequestMethod.POST)
//    @ResponseBody
//    public PageResult queryGroup(HttpServletRequest request){
//
//        Map<String,Object> map = buildSearchParam(request);
//        PageBean<Group> pageInfo = groupService.queryGroupByPage(map);
//
//        return showPageResult(pageInfo);
//    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult getGroupById(@PathVariable int id) throws CustomException{

        GroupDetailDto groupDetail = groupService.getGroupById(id);
        return showJsonResult(true,"查询成功",groupDetail) ;
    }

    @RequestMapping(value="/getGroupTree",method=RequestMethod.GET)
    @ResponseBody
    public List getGroupTree(){

        List<TreeDto> roleTree = groupService.getGroupList(0);

        return roleTree;

    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addGroup(HttpServletRequest request){

        String groupParent     = request.getParameter("s_group_id") ;
        String groupParentName = request.getParameter("s_group_name") ;

        ModelAndView model = new ModelAndView("group/addGroup");
        model.addObject("groupParent",groupParent);
        model.addObject("groupParentName",groupParentName);

        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertGroup(@ModelAttribute Group group) throws CustomException {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        String createTime  = DateUtils.getDateTime();
        group.setCreateTime(createTime);

        try {
            groupService.insertGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"保存成功",null) ;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editGroup(@PathVariable int id){

        ModelAndView model = new ModelAndView("Group/editGroup");

        Group Group  = groupService.getGroupById(id);
        model.addObject("group", Group);

        return model;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateGroup(@ModelAttribute Group group) throws CustomException{

        try {
            groupService.updateGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"更新成功",null) ;
    }

    @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteGroup(@PathVariable int id) throws CustomException{

        try {
            groupService.deleteGroup(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"删除成功",null) ;
    }

}
