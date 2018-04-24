package com.example.demo.service.impl;

import com.example.demo.event.BlackListEvent;
import com.example.demo.service.EmailService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/4/24 15:32
 **/
@Service
public class EmailServiceImpl implements EmailService,ApplicationEventPublisherAware {


    public ApplicationEventPublisher publisher;


    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEmail(String address, String text) {

       List<String> blackList = new ArrayList<>();
       blackList.add("1");
        blackList.add("2");
        blackList.add("3");
        blackList.add("4");
        blackList.add("5");
        if (blackList.contains(address)) {
            BlackListEvent event = new BlackListEvent(this, address, text);
            publisher.publishEvent(event);
            System.out.println("publish event end....");
            return;
        }
        // send email...
    }
}
