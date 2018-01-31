package com.ybw.demo.aspect;

import com.ybw.demo.utils.holder.DataSourceHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by yao on 2018/1/29
 *
 * aop拦截mapper层，设置数据源，没有开启事务机制
 *
 */


@Aspect
@Component
public class DataSourceInMapperAspect {

    /**
     * 拦截路径 读库
      */
    @Pointcut("execution(public * com.ybw.demo.mapper.*.*find*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*get*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*select*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*query*(..))")
    private void readPath(){}

    /**
     * 拦截路径 写库
     */
    @Pointcut("execution(public * com.ybw.demo.mapper.*.*add*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*update*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*insert*(..)) || " +
            "execution(public * com.ybw.demo.mapper.*.*delete*(..)) ||" +
            "execution(public * com.ybw.demo.mapper.*.*count*(..)) ||" +
            "execution(public * com.ybw.demo.mapper.*.*save*(..))")
    private void writePath(){}

    /**
     * 设置库
     * 读
     */
    @Before("readPath()")
    public void readBefore(){
        DataSourceHolder.setRead();
    }

    /**
     * 设置库
     * 写
     */
    @Before("writePath()")
    public void writeBefore(){
        DataSourceHolder.setWrite();
    }

}
