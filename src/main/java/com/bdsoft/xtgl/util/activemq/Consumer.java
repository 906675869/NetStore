package com.bdsoft.xtgl.util.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receiveQueue(String text) {
        //接收到消息后的操作
        System.out.println(text+" Consumer receive");
    }

}