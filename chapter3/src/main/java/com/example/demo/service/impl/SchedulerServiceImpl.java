package com.example.demo.service.impl;

import com.example.demo.service.SchedulerService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 10:21
 **/
@Service
public class SchedulerServiceImpl implements SchedulerService {


    @Async // 异步
    @Override
    @Scheduled(fixedRate = 100)
    public void fixedRate() {

        System.out.println(Thread.currentThread().getName());
    }

    @Async
    @Override
    @Scheduled(fixedRate = 100)
    public void fixedRate2() {
        System.out.println(Thread.currentThread().getName());
    }
}
