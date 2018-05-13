package com.example.demo.service;

import com.example.demo.repository.PO.Duck;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 18:17
 **/
public interface DuckService {

    Duck findById(Integer id);

    Duck save(Duck duck1);
}
