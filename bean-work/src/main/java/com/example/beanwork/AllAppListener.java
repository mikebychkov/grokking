package com.example.beanwork;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AllAppListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("#".repeat(50) + AllAppListener.class);
        System.out.println(applicationEvent);
    }
}
