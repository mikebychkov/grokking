package com.example.beanwork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        ConfigurableApplicationContext context = app.run(DemoApplication.class, args);
    }

    @Bean(initMethod = "init")
    public SomeModel someModel(MyBean myBean) {
        SomeModel model = new SomeModel("Holy Moly");
        model.setMyBean(myBean);
        return model;
    }

    @Bean
    @Autowired
    public CommandLineRunner run(MyContextAware myContextAware, MyContextAutowired myContextAutowired, SomeModel model) {
        return args -> {
            myContextAware.fireEvent();
            Thread.sleep(5000);
            myContextAutowired.fireEvent();
            //
            System.out.println("=".repeat(20) + model);
        };
    }
}
