package com.example.demo.service.impl;

import com.example.demo.repository.PO.Duck;
import com.example.demo.repository.PO.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.DuckService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 19:30
 **/
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private DuckService duckService;

    @Override
    @Transactional
    public void save(Role role) {

        roleRepository.save(role);
        this.update(role.getId());

    }

    @Override
    public void update(Integer id) {
        Duck duck = new Duck();
        duck.setId(2222);
        duck.setType("222");
        duck.setColor("333333");
        duckService.save(duck);
        Optional<Role> role = roleRepository.findById(id);

        Role role1 = role.get();
        role1.setName("信号啊");

        roleRepository.save(role1);

//        throw new RuntimeException("不要啊");
    }
}
