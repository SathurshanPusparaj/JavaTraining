package com.cloudbox.taskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
public class TaskserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskserviceApplication.class, args);
    }

}
