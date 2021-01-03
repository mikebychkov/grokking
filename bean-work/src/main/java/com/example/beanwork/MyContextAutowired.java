package com.example.beanwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component(value = "ep2")
public class MyContextAutowired implements EventProducer {

    private ApplicationContext context;

    @Autowired
    public MyContextAutowired(ApplicationContext context) {
        System.out.println("####### SET APP CONTEXT AUTOWIRED");
        this.context = context;
    }

    public void fireEvent() {
        context.publishEvent(new MyAppEvent(this, LocalDateTime.now()));
    }

}
