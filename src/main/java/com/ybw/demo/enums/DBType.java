package com.ybw.demo.enums;

/**
 * Created by yao on 2018/1/29
 *
 * 读、写分离
 */

public enum DBType {

    WRITE("write","写库"),READ("read","读库");

    private String type;

    private String name;

    DBType(String type,String name){
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
