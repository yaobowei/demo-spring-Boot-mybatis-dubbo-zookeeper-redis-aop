package com.ybw.demo.utils.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by yao on 2018/1/18
 *
 * 返回值基类
 */

@Getter
@Setter
public class Result<T> {


    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应内容
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
