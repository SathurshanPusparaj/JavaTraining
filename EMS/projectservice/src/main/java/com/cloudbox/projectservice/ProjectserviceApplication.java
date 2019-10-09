package com.cloudbox.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
public class ProjectserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectserviceApplication.class, args);
    }

}
