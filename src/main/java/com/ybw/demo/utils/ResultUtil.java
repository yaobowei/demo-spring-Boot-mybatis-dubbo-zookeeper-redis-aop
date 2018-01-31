package com.ybw.demo.utils;

import com.ybw.demo.enums.ResultEnums;
import com.ybw.demo.utils.model.Result;

/**
 * Created by yao on 2018/1/18
 *
 * 返回值工具
 */
public class ResultUtil {

    /**成功*/
    public static Result success(Object object){
        Result<Object> result = new Result<>();
        result.setCode(ResultEnums.SUCCESS.getCode());
        result.setMessage(ResultEnums.SUCCESS.getMessage());
        result.setData(object);
        return result;
    }
    /**错误*/
    public static Result error(){
        Result<Object> result = new Result<>();
        result.setCode(ResultEnums.ERROR.getCode());
        result.setMessage(ResultEnums.ERROR.getMessage());
        result.setData(null);
        return result;
    }
    /**异常*/
    public static Result exception(Exception e){
        Result<Object> result = new Result<>();
        result.setCode(ResultEnums.EXCEPTION.getCode());
        result.setMessage(ResultEnums.EXCEPTION.getMessage());
        result.setData(e.getMessage());
        return result;
    }



}
