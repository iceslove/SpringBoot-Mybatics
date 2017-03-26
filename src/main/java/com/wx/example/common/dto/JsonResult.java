package com.wx.example.common.dto;

import java.io.Serializable;

/**
 * Created by wangxiong on 2017/3/18.
 */
public class JsonResult implements Serializable {

	private static final long serialVersionUID = -415196579462215370L;

	public static final int SUCCESS = 1;
	public static final int ERROR = 0;

	public JsonResult(){
	}

	public JsonResult(int code){
		this.code = code ;
	}

	private int code;
	
	private String msg;
	
	private Object data;

	private String url;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

