package com.example.demo.repository;

import com.example.demo.repository.PO.Duck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/11 17:28
 **/
public interface DuckRepository extends  JpaRepository<Duck,Integer> {



}
