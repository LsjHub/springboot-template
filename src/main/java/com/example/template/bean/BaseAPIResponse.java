package com.example.template.bean;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class BaseAPIResponse implements Serializable {

    private static final long serialVersionUID = 6097373689727227364L;

    public static final Integer OK_CODE = 0;

    public static final String OK_MSG = "OK";

    private Integer code = 0;

    private JSONObject data = new JSONObject();

    private String msg = "OK";

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseAPIResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}
