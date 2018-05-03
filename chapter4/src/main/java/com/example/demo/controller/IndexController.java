package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/28 11:11
 **/
@RestController
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){

        System.out.println("IndexController.index");
        return "index";
    }

    @RequestMapping(value = "/async")
    public Callable<String> processUpload() {

        return () -> {
            System.out.println("async.....");
            return "index";
        };

    }
}
