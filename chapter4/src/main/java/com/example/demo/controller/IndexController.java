package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/28 11:11
 **/
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        System.out.println("IndexController.index");
        return "index";
    }
}
