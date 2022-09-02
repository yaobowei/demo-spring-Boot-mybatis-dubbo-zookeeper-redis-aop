package com.ybw.demo.utils;

import org.springframework.data.redis.core.script.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yao on 2018/1/19
 * 自定义工具类
 */
public class Util {

    public static String string2Md5(String str){
        if(str == null) str = "";
        return DigestUtils.sha1DigestAsHex(str);
    }

}
