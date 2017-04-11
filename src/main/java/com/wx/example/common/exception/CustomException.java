package com.wx.example.common.exception;

/**
 * Created by wangxiong on 2017/3/21.
 */
public class CustomException extends RuntimeException{

    public CustomException() {
        super();
    }

    public CustomException(String msg) {
        super(msg);
    }

}
