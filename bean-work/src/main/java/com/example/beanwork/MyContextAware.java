package com.example.beanwork;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component(value = "ep1")
public class MyContextAware implements ApplicationContextAware, EventProducer {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("####### SET APP CONTEXT AWARE");
        this.context = applicationContext;
    }

    public void fireEvent() {
        context.publishEvent(new MyAppEvent(this, LocalDateTime.now()));
    }
}
