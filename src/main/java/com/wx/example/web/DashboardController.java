package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin")
public class DashboardController extends BaseController {

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modal = new ModelAndView("index");
        return modal;
    }

}
