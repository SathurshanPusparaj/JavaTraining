package com.cloudbox.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
@EnableResourceServer
public class TaskserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskserviceApplication.class, args);
    }

}
