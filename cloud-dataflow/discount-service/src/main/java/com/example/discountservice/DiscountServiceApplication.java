package com.example.discountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(value = Processor.class)
public class DiscountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountServiceApplication.class, args);
    }

}
