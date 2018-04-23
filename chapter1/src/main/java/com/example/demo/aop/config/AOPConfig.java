package com.example.demo.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: zouqinjia
 * Description:AOP相关配置类
 * Date:2018/4/23 11:09
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.example.demo.*")
public class AOPConfig {




}
