package com.example.demo.service.impl;

import com.example.demo.service.MuticastService;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/24 17:36
 **/
public class MuticastServiceImpl implements MuticastService {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("1");
        list2.add("2");

        list1.forEach(s -> {
            list2.stream().filter(s1 -> s1.equals(s)).forEach(s1 -> {
                System.out.println(s1);
            });
        });
    }

}
