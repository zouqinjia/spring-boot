package com.example.demo.controller;

import com.example.demo.repository.PO.Duck;
import com.example.demo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/13 16:22
 **/
@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value="/save")
    public Duck save(){

        Duck duck = new Duck();
        duck.setId(1001);
        duck.setColor("22222");
        duck.setType("333333");
        return cacheService.save(duck);
    }

    @RequestMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id){

        cacheService.remove(id);
    }

    @RequestMapping(value = "/find/{id}")
    public Duck findOne(@PathVariable("id") Integer id){

        return cacheService.findOne(id);
    }


}
