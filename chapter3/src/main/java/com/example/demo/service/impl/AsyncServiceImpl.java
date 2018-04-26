package com.example.demo.service.impl;

import com.example.demo.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/26 18:27
 **/
@Service
public class AsyncServiceImpl implements AsyncService {


    @Async
    @Override
    public void asyncMethod(int i) {

        System.out.println("AsyncServiceImpl.asyncMethod"+i);
    }

    @Override
    public void asyncMthod2(int i) {

        System.out.println("AsyncServiceImpl.asyncMthod2, "+i );
    }
}
