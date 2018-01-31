package com.ybw.demo.enums;

/**
 * Created by yao on 2018/1/18
 *
 * 返回值
 */
public enum ResultEnums {

    SUCCESS(1,"获取成功"),ERROR(-1,"获取失败"),EXCEPTION(-1,"获取异常");

    private Integer code;

    private String message;

    ResultEnums(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
