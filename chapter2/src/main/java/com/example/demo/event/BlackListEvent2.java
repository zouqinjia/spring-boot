package com.example.demo.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Author: zouqinjia
 * Description: 事件
 * Date:2018/4/24 14:50
 **/
@Data
public class BlackListEvent2 extends ApplicationEvent {

    private final String  address;
    private final String test;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public BlackListEvent2(Object source, String address, String test) {

        super(source);
        this.address = address;
        this.test = test;
        System.out.println("BlackListEvent2.BlackListEvent");
    }


    // accessor and other methods...
}
