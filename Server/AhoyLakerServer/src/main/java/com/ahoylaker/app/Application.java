package com.ahoylaker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ahoylaker.actions.rest, com.ahoylaker.actions.view")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
