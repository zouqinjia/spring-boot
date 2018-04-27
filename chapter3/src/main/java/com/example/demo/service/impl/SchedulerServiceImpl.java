package com.example.demo.service.impl;

import com.example.demo.service.SchedulerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 10:21
 **/
@Service
public class SchedulerServiceImpl implements SchedulerService {


    @Override
    @Scheduled(fixedRate = 500)
    public void fixedRate() {

        StopWatch stopWatch  = new StopWatch();
        stopWatch.start("fixedRate");
        stopWatch.prettyPrint();
        System.out.println("SchedulerServiceImpl.fixedRate" + System.currentTimeMillis());
    }
}
