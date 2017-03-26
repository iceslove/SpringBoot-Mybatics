package com.wx.example.web;

import com.wx.example.common.dto.PageResult;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.exception.CustomException;
import com.wx.example.common.utils.DateUtils;
import com.wx.example.entity.Menu;
import com.wx.example.service.MenuService;
import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){

        List<Menu> menuTree = menuService.getMenuList(0);
        ModelAndView modal = new ModelAndView("menu/index");

        modal.addObject("menus",menuTree);

        return modal;
    }

    @RequestMapping(value="/query",method=RequestMethod.POST)
    @ResponseBody
    public PageResult queryMenu(HttpServletRequest request){

        Map<String,Object> map = buildSearchParam(request);
        PageBean<Menu> pageInfo = menuService.queryMenuByPage(map);

        return showPageInfo(pageInfo);
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Menu getMenuById(@PathVariable int id) {

        return menuService.getMenuById(id);
    }

    @RequestMapping(value="/getFirstMenu", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult getFirstMenu() {
        List<Menu> list = menuService.getFirstMenu();
        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setData(list);
        return result;
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addMenu(){
        ModelAndView model = new ModelAndView("menu/addMenu");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertMenu(@ModelAttribute Menu menu) throws CustomException {
        String createTime  = DateUtils.getDateTime();
        menu.setCreateTime(createTime);
        menu.setMenuLeaf(1);

        try {
            menuService.insertMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("保存成功");

        return result;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editMenu(@PathVariable int id){

        ModelAndView model = new ModelAndView("menu/editMenu");

        Menu Menu  = menuService.getMenuById(id);
        model.addObject("menu", Menu);

        return model;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateMenu(@ModelAttribute Menu menu) throws CustomException{

        try {
            menuService.updateMenu(menu);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("更新成功");
        return result;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    @ResponseBody
    public JsonResult deleteMenu(@PathVariable int id) throws CustomException{

        try {
            menuService.deleteMenu(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("删除成功");
        return result;
    }


}
