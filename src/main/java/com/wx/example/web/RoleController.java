package com.wx.example.web;

import com.wx.example.common.dto.PageResult;
import com.wx.example.common.utils.DateUtils;
import com.wx.example.entity.Menu;
import com.wx.example.service.RoleService;
import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.exception.CustomException;
import com.wx.example.entity.Role;
import com.wx.example.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("role/index");
        return modal;
    }

    @RequestMapping(value="/query",method=RequestMethod.POST)
    @ResponseBody
    public PageResult queryRole(HttpServletRequest request){

        Map<String,Object> map = buildSearchParam(request);
        PageBean<Role> pageInfo = roleService.queryRoleByPage(map);

        return showPageResult(pageInfo);
    }

    @RequestMapping(value="/getRoleTree",method=RequestMethod.GET)
    @ResponseBody
    public List getRoleTree(){

        List<Role> list = roleService.getRoleList();

        List roleTree = new ArrayList();

        for (Role role: list) {
            Map map = new HashMap();
            map.put("id",role.getRoleId());
            map.put("text",role.getRoleName());
            map.put("state",true);
            map.put("children",null);
            roleTree.add(map);
        }

        return roleTree;

    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Role getRoleById(@PathVariable int id) {

        return roleService.getRoleById(id);
    }

    @RequestMapping("/add")
    public ModelAndView addRole(){
        ModelAndView model = new ModelAndView("role/addRole");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertRole(@ModelAttribute Role role) throws CustomException {
        String createTime  = DateUtils.getDateTime();
        role.setCreateTime(createTime);

        try {
            roleService.insertRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"保存成功",null) ;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editRole(@PathVariable int id){

        ModelAndView model = new ModelAndView("role/editRole");

        Role Role  = roleService.getRoleById(id);
        model.addObject("role", Role);

        return model;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateRole(@ModelAttribute Role role) throws CustomException{

        try {
            roleService.updateRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"更新成功",null) ;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteRole(@PathVariable int id) throws CustomException{

        try {
            roleService.deleteRole(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }
        return showJsonResult(true,"删除成功",null) ;
    }

    @RequestMapping(value="selectMenus/{roleId}", method=RequestMethod.GET)
    public ModelAndView selectMenu(@PathVariable int roleId){

        List<Menu> list = roleService.getCheckedMenus(roleId,0);

        ModelAndView modal = new ModelAndView("role/selectMenus");
        modal.addObject("roleId",roleId) ;
        modal.addObject("menus",list) ;

        return modal;
    }

    @RequestMapping(value="saveMenus", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult saveMenu(HttpServletRequest request) throws CustomException{

        try {
            int roleId = Integer.parseInt(request.getParameter("roleId")) ;
            String[] menus = request.getParameterValues("menuId") ;

            roleMenuService.saveRoleMenu(roleId,menus);
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(e.getClass().toString());
        }
        return showJsonResult(true,"保存成功",null) ;
    }

}
