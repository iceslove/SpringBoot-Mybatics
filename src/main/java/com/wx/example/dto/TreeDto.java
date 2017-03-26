package com.wx.example.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by wangxiong on 2017/3/18.
 */

public class TreeDto implements java.io.Serializable{
    private static final long serialVersionUID=1L;

    private Integer id;

    private String text;

    private Map<String,Object> state;

    private List<?> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }
}
