package com.example.demo.combination;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/27 13:46
 **/

@AliasAnnotation(aa = "aaa")
public class AnnotationTest {


    public static void main(String[] args) {

        AliasAnnotation anno1 = AnnotationTest.class.getAnnotation(AliasAnnotation.class);

        System.out.println(JSON.toJSONString(anno1.aa()));

        AliasAnnotation anno = AnnotationTest.class.getAnnotation(AliasAnnotation.class);
        if(anno != null){
            Method[] met = anno.annotationType().getDeclaredMethods();
            for(Method me : met ){
                if(!me.isAccessible()){
                    me.setAccessible(true);
                }
                try {
                    System.out.println(me.invoke(anno, null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
