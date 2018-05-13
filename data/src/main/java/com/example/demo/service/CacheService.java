package com.example.demo.service;

import com.example.demo.repository.PO.Duck;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/13 16:24
 **/
public interface CacheService {

    Duck save(Duck duck);
    void remove(Integer id);
    Duck findOne(Integer id);
}
