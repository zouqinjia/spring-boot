package com.example.demo.combination;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 13:20
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
public @interface CombinationAnnotation {

    @AliasFor(annotation = ComponentScan.class)
    String value();
}
