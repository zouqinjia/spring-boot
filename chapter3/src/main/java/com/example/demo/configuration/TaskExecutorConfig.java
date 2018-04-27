package com.example.demo.configuration;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/26 15:29
 **/
@EnableAsync
@Configuration
public class TaskExecutorConfig implements AsyncConfigurer{

    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);// 初始化线程数
        threadPoolTaskExecutor.setKeepAliveSeconds(2);// 线程存活等待时间，过时回收
        threadPoolTaskExecutor.setMaxPoolSize(20);// 线程池最大线程数
        threadPoolTaskExecutor.setQueueCapacity(25);// 线程等待对列容量
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        // 异常处理

        return null;
    }
}
