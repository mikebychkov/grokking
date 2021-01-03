package com.example.beanwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyBean {

    private AnotherOne anotherOne;

    @Autowired
    public MyBean(AnotherOne anotherOne) {
        this.anotherOne = anotherOne;
    }

    public AnotherOne getAnotherOne() {
        return anotherOne;
    }

    public void setAnotherOne(AnotherOne anotherOne) {
        this.anotherOne = anotherOne;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "anotherOne=" + anotherOne +
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
