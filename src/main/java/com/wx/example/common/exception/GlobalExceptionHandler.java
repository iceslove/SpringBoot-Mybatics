package com.wx.example.common.exception;

import com.wx.example.common.dto.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangxiong on 2017/3/21.
 * 统一异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", e);
        model.addObject("url", req.getRequestURL());
        model.setViewName("error");
        return model;
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public JsonResult jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception {
        JsonResult r = new JsonResult();
        r.setCode(JsonResult.ERROR);
        r.setMsg(e.getMessage());
        r.setData("some error data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }

}
