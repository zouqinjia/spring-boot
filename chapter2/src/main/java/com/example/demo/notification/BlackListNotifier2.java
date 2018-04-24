package com.example.demo.notification;

import com.alibaba.fastjson.JSON;
import com.example.demo.event.BlackListEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BlackListNotifier2{

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...

        System.out.println("event is : "+ JSON.toJSONString(event));
        System.out.println("BlackListNotifier2.processBlackListEvent");
    }
}