package com.example.demo.combination;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AliasAnnotation {

    @AliasFor(value = "aaa")// 属性别名，用于组合注解避免属性冲突。属性之间隐式互换
    String aa() default "";
}  