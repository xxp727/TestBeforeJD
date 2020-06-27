package com.example.device.domain;

import java.io.Serializable;

public class RespBean<T> {
    Integer code;
    String msg;
    T object;

    public RespBean(){}

    public RespBean(Integer code, String msg, T object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
