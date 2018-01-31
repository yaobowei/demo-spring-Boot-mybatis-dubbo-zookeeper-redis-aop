package com.ybw.demo.aspect;

import com.ybw.demo.utils.model.Result;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yao on 2018/1/17
 * 测试aop
 */

@Aspect
@Component
public class DemoAspect {

    /**
     * looger方法
     */
    private Logger logger = LoggerFactory.getLogger(DemoAspect.class);

    /**
     * 路径模版
     */
    @Pointcut("execution(public * com.ybw.demo.controller.*.*(..))")
    private void toPath(){}


    /**
     * 方法执行之后
     */
    @After("toPath()")
    public void doAfter(){
        logger.info("DemoAspect={}","doAfter");
    }


    /**
     * 方法执行前
     * 打印出地址及参数
     * @param joinPoint
     */
    @Before("toPath()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //
        logger.info("请求地址={}",request.getRequestURL());

        logger.info("请求类型={}",request.getMethod());

        logger.info("请求ip={}",request.getRemoteAddr());

        logger.info("类名={}",joinPoint.getSignature().getDeclaringTypeName());

        logger.info("参数={}",joinPoint.getArgs());

    }


    @AfterReturning(returning = "result" ,pointcut = "toPath()")
    public void doAfterReturning(Result result){
        if(result.getCode()!=1){
            logger.error(result.getMessage(),result.getData());
        }else {
            logger.info("返回值={}", result.getData().toString());
        }
    }

}
