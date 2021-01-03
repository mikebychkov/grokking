package com.example.beanwork;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyAppListener implements ApplicationListener<MyAppEvent> {

    @Override
    public void onApplicationEvent(MyAppEvent myAppEvent) {
        System.out.println("#".repeat(50) + MyAppListener.class);
        System.out.println(myAppEvent);
    }
}
