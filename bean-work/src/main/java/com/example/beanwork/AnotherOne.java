package com.example.beanwork;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class AnotherOne {

    private String value = "Nierautomata";

    public AnotherOne() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AnotherOne{" +
                "value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    private void init() {
        System.out.println("\n\n");
        System.out.println("POST CONSTRUCT: " + this);
        System.out.println("\n\n");
    }

    @PreDestroy
    private void close() {
        System.out.println("\n\n");
        System.out.println("PRE DESTROY: " + this);
        System.out.println("\n\n");
    }
}
