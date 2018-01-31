package com.ybw.demo.utils.holder;

import com.ybw.demo.enums.DBType;

/**
 * Created by yao on 2018/1/29
 * 读、写分离线程
 */
public class DataSourceHolder {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读库
     */
    public static void setRead() {
        local.set(DBType.READ.getType());
        //log.info("数据库切换到读库...");
    }

    /**
     * 写库
     */
    public static void setWrite() {
        local.set(DBType.WRITE.getType());
        //log.info("数据库切换到写库...");
    }

    public static String getReadOrWrite() {
        return local.get();
    }

    public static void clear(){
        local.remove();
    }

}
