package com.example.demo.innerclass;

import lombok.Data;

import java.util.List;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/9 11:05
 **/
@Data
public class A {

    private String a;

    private List<B> bs;

    @Data
    public  class B{

        private String b;
    }
}
