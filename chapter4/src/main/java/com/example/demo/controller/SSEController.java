package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/5 21:04
 **/
@RestController
public class SSEController {

    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8") //①
    public String push() {

        Random r = new Random();
//        try {
////            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";
    }


}
