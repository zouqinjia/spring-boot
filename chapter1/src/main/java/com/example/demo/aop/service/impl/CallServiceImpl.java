package com.example.demo.aop.service.impl;

import com.example.demo.aop.annotation.Audible;
import com.example.demo.aop.annotation.AuditCode;
import com.example.demo.aop.service.CallService;
import org.springframework.stereotype.Service;

/**
 * Created by pc on 2018/4/23.
 */
@Service
public class CallServiceImpl implements CallService {

    @Override
    @Audible(AuditCode.CODE1)
    public void audible() {

        System.out.println("AOPDemoServiceImpl.audible");
    }
}
