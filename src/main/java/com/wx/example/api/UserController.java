package com.wx.example.api;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/api/user")
public class UserController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult getAccountById(@PathVariable int id){
        Account account = accountService.getAccountById(id);
        return showJsonResult(true,"查询成功",account) ;
    }

}
