package com.jitendra.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;


public class TestOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrderServiceApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
