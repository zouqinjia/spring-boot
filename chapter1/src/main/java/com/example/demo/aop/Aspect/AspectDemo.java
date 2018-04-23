package com.example.demo.aop.Aspect;

import com.alibaba.fastjson.JSON;
import com.example.demo.aop.annotation.Audible;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/23 12:23
 **/
@Aspect
@Component
public class AspectDemo {

    @Pointcut(value = "@annotation(com.example.demo.aop.annotation.Action)")
    public void printLog(){

    }

    @Before(value = "printLog()")
    public void before(JoinPoint joinPoint){

        Object [] objects = joinPoint.getArgs();
        System.out.println("JoinPoint parameter  is : " + JSON.toJSONString(objects));
        System.out.println("AspectDemo.before");
    }



    @Pointcut(value="execution(* com.example.demo.aop.service.*.*(..)) && args(oppId,..)")
    public void argPointCut(String oppId){

    }

    @Before(value = "argPointCut(oppId)")
    public void after(JoinPoint joinPoint,String oppId){

        System.out.println("before parameter is : " + JSON.toJSONString(joinPoint.getArgs()));
        System.out.println("通知中获取到的oppI:"+oppId);

    }


    @Pointcut(value="execution(* com.example.demo.aop.service.*.*(..))")
    public void aroundPointCut(){

    }

    @Order(1)
    @Around(value = "aroundPointCut() && @annotation(audible)")
    public void around(ProceedingJoinPoint proceedingJoinPoint,Audible audible) throws Throwable {


        System.out.println("AspectDemo.around");
        System.out.println(JSON.toJSONString(audible.value()));
        proceedingJoinPoint.proceed();
    }


}
