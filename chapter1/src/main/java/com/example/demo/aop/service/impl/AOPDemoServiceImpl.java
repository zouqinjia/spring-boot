package com.example.demo.aop.service.impl;

import com.example.demo.aop.annotation.Action;
import com.example.demo.aop.annotation.Audible;
import com.example.demo.aop.annotation.AuditCode;
import com.example.demo.aop.service.AOPDemoService;
import org.springframework.stereotype.Service;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/23 14:24
 **/
@Service
public class AOPDemoServiceImpl implements AOPDemoService {


    @Action(name = "执行add操作")
    public void add(){
        System.out.println("AOPDemoService.add");
    }


    public void update(String oppId,String... strArg){

        System.out.println("AOPDemoServiceImpl.update");
    }

    @Override
    @Audible(AuditCode.CODE1)
    public void audible() {

        System.out.println("AOPDemoServiceImpl.audible");
    }
}
