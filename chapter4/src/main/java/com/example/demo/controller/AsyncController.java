package com.example.demo.controller;

import com.example.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/5 21:41
 **/
@RestController
public class AsyncController {

    @Autowired
    private PushService pushService;

    @RequestMapping("/deffer")
    public DeferredResult<String> serverSentEvent(){

        System.out.println("AsyncController.serverSentEvent");

        return pushService.pushData();
    }

}
