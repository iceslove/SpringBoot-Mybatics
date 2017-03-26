package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.dto.PageResult;
import com.wx.example.common.entity.PageBean;
import com.wx.example.common.exception.CustomException;
import com.wx.example.common.utils.DateUtils;
import com.wx.example.common.utils.Md5Util;
import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("account/index");
        return modal;
    }

    @RequestMapping(value="/query",method=RequestMethod.POST)
    @ResponseBody
    public PageResult queryAccount(HttpServletRequest request){

        Map<String,Object> map = buildSearchParam(request);
        PageBean<Account> pageInfo = accountService.queryAccountByPage(map);

        return showPageInfo(pageInfo);
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Account getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public ModelAndView addAccount(){
        ModelAndView model = new ModelAndView("account/addAccount");
        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult insertAccount(@ModelAttribute Account account) throws CustomException {
        String createTime  = DateUtils.getDateTime();
        account.setCreateTime(createTime);

        try {
            accountService.insertAccount(account);
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
    public ModelAndView editAccount(@PathVariable int id){

        ModelAndView model = new ModelAndView("account/editAccount");

        Account account  = accountService.getAccountById(id);
        model.addObject("account", account);

        return model;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateAccount(@ModelAttribute Account account) throws CustomException{

        try {
            accountService.updateAccount(account);
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
    public JsonResult deleteAccount(@PathVariable int id) throws CustomException{

        try {
            accountService.deleteAccount(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("删除成功");
        return result;
    }

    @RequestMapping(value="/showResetPassword/{id}", method=RequestMethod.GET)
    public ModelAndView showResetPassword(@PathVariable int id){

        ModelAndView model = new ModelAndView("account/password");
        model.addObject("accountId", id);

        return model;
    }

    @RequestMapping(value="/resetPassword", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult resetPassword(HttpServletRequest request) throws CustomException{

        try {
            int accountId = Integer.valueOf(request.getParameter("accountId"));
            String password = Md5Util.generatePassword(request.getParameter("password"));

            accountService.updatePassword(accountId, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("更新成功");
        return result;
    }

}
