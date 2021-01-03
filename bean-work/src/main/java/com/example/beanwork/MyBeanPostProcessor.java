package com.example.beanwork;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\n\n");
        System.out.println("BEAN POST PROCESSOR --BEFORE: " + bean);
        System.out.println("\n\n");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("\n\n");
        System.out.println("BEAN POST PROCESSOR --AFTER: " + bean);
        System.out.println("\n\n");
        return bean;
    }

    @Override
    public String toString() {
        return "MyBeanPostProcessor{}";
    }
}
