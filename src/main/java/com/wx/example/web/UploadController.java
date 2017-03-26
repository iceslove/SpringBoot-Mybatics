package com.wx.example.web;

import com.wx.example.common.controller.BaseController;
import com.wx.example.common.dto.JsonResult;
import com.wx.example.common.exception.CustomException;
import com.wx.example.common.utils.FileUploadUtils;
import com.wx.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wangxiong on 2017/3/18.
 */

@Controller
@RequestMapping(value="/admin/uploadFile")
public class UploadController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public JsonResult updateProfile(@RequestParam(value = "file", required = false) MultipartFile file) throws CustomException {
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
