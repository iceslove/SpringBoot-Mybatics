package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.exception.CustomException;
import com.wx.example.common.utils.FileUploadUtils;
import com.wx.example.entity.Account;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/profile")
public class ProfileController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession();

//        int accountId = Integer.parseInt((String)session.getAttribute("accountId"));
//        Account account = accountService.getAccountById(accountId);

        ModelAndView modal = new ModelAndView("account/profile");
//        modal.addObject("account",account) ;
        return modal;
    }

    @RequestMapping(value="/updateProfile", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateProfile(@ModelAttribute Account account) throws CustomException {
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

    @RequestMapping(value="/updateUserPhoto", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateUserPhoto(@RequestParam(value = "userPhoto", required = false) MultipartFile file) throws CustomException {

        try {
            FileUploadUtils.restore(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException();
        }

        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg("成功");
        return result;
    }


}
