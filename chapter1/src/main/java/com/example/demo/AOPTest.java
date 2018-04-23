package com.example.demo;

import com.example.demo.aop.config.AOPConfig;
import com.example.demo.aop.service.AOPDemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/23 14:07
 **/

public class AOPTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        AOPDemoService aopDemoService = context.getBean(AOPDemoService.class);
        aopDemoService.add();
        aopDemoService.update("潜客id","1","2","3");
//        aopDemoService.audible();
        aopDemoService.call();
        context.close();

    }
}
