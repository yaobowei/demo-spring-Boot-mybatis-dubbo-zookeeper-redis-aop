package com.ybw.demo.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by yao on 2018/1/25
 * 自定义读、写分离异常
 */
public class ReadWriteDataSourceTransactionException extends NestedRuntimeException {

    public ReadWriteDataSourceTransactionException(String msg,Throwable cause){
        super(msg, cause);
    }


}
