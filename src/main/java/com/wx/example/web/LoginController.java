package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin") // 通过这里配置使下面的映射都在/users下
public class LoginController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "error", required = false) String error){
        ModelAndView model = new ModelAndView("auth/login");
        if (error != null) {
            model.addObject("error", "不正确的用户名和密码");
        }
        return model;
    }

//    @RequestMapping(value="/logout",method= RequestMethod.POST)
//    public String logout(){
//        return "redirect:admin/login";
//    }

}
