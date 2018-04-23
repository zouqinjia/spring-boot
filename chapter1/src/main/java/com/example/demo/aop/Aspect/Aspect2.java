package com.example.demo.aop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/23 15:17
 **/
@Aspect
@Component
public class Aspect2 {

    @Pointcut(value="")
    public void argPointCut(){

    }
}
