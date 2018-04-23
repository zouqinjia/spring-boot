package com.example.demo.aop.service.impl;

import com.example.demo.aop.annotation.Action;
import com.example.demo.aop.annotation.Audible;
import com.example.demo.aop.annotation.AuditCode;
import com.example.demo.aop.service.AOPDemoService;
import com.example.demo.aop.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/23 14:24
 **/
@Service
public class AOPDemoServiceImpl implements AOPDemoService {

    @Autowired
    private CallService callService;

    @Action(name = "执行add操作")
    public void add(){
        System.out.println("AOPDemoService.add");
    }


    public void update(String oppId,String... strArg){

        System.out.println("AOPDemoServiceImpl.update");
    }


    /**
     * 方法调用切面不能在同一个类中，否则不生效。
     * 需要另行注入才能生效
     */
    @Override
    public void call() {

        callService.audible();
    }
}
