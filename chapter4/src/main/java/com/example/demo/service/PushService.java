package com.example.demo.service;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/5 21:46
 **/
public interface PushService {

    DeferredResult<String> pushData();

}
