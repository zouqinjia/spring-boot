package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/24 14:36
 **/
@RunWith(JUnit4.class)
public class JavaApplicationTest {


    @Test
    public void testIgnoreEmoji(){
        String aa = "\\xF0\\x9F\\x93\\xB4";
        String bb = convert(aa);
        bb.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
        System.out.print(bb);
    }




}
