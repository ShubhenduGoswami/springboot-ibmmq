package com.example.mqspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import com.example.mqspring.controllers.MQController;
import com.example.mqspring.service.MQService;

@SpringBootApplication
@EnableJms
@ComponentScan (basePackageClasses = { MQController.class, MQService.class })
public class MqspringApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqspringApplication.class, args);
    }

}
