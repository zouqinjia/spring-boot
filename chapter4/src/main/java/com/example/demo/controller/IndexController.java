package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.Callable;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/28 11:11
 **/
@RestController
public class IndexController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){

        System.out.println("IndexController.index");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 异步请求
     * @return
     */
    @RequestMapping(value = "/asyncs")
    public Callable<String> processUpload() {

        return () -> {
            System.out.println("async.....");
            return "index";
        };

    }

    @RequestMapping("/exception")
    public String exception(){

        if(true){

            throw new RuntimeException("报错了");
        }

        return "error";
    }
}
