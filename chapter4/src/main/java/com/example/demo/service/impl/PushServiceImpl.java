package com.example.demo.service.impl;

import com.example.demo.service.PushService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/5 21:47
 **/
@Service
public class PushServiceImpl implements PushService {

    private DeferredResult<String> stringDeferredResult;

    @Override
    public DeferredResult<String> pushData() {

        System.out.println("PushServiceImpl.pushData");

        stringDeferredResult  = new DeferredResult<>();
        return stringDeferredResult;
    }

    @Scheduled(fixedRate = 5000)
    public void refresh(){

        System.out.println("PushServiceImpl.refresh,deferred is " + stringDeferredResult);
        if(stringDeferredResult != null){

            stringDeferredResult.setResult(System.currentTimeMillis()+"");
        }
    }
}
