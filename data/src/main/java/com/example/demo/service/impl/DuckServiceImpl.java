package com.example.demo.service.impl;

import com.example.demo.repository.DuckRepository;
import com.example.demo.repository.PO.Duck;
import com.example.demo.service.DuckService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 18:17
 **/
@Service
public class DuckServiceImpl implements DuckService {

    @Autowired
    private DuckRepository duckRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public Duck findById(Integer id) {

        return duckRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Duck save(Duck duck1) {
        Duck duck = duckRepository.save(duck1);
        return null;
    }
}
