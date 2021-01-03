package com.example.beanwork;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class MyAppEvent extends ApplicationEvent {

    private LocalDateTime time;

    public MyAppEvent(Object source, LocalDateTime time) {
        super(source);
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyAppEvent{" +
                "time=" + time +
                ", source=" + source +
                '}';
    }
}
