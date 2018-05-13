package com.example.demo.service.impl;

import com.example.demo.repository.DuckRepository;
import com.example.demo.repository.PO.Duck;
import com.example.demo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/13 16:26
 **/
@Service
@Transactional
public class CacheServiceImpl implements CacheService {

    @Autowired
    private DuckRepository duckRepository;

    /**
     * 无论如何将数据存入内存
     * 将传入参数的id作为key，返回的对应作为value，保存到内存中
     */
    @Override
    @CachePut(value = "duck",key = "#duck.id")
    public Duck save(Duck duck) {
        Duck save = duckRepository.save(duck);
        System.out.println("存入缓存"+"key:"+save.getId()+"value:" +save.toString());
        return save;
    }

    /**
     * key：传入的参数，缓存name='duck'，从内存中删除
     */
    @Override
    @CacheEvict(value = "duck")
    public void remove(Integer id) {

        System.out.println("移除缓存"+"key:"+id);
        duckRepository.deleteById(id);
    }

    /**
     *检查内存中是否存在key为方法参数的缓存，如果有直接从内存中去数据，分之查询数据库存入到内存中，key=方法参数，value=返回对象
     */
    @Override
    @Cacheable(value = "duck")
    public Duck findOne(Integer id) {

        Duck duck = duckRepository.findById(id).get();
        System.out.println("存入缓存"+"key:"+duck.getId()+"value:" +duck.toString());
        return duck;
    }
}
