package com.cloudbox.projectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
@EnableResourceServer
public class ProjectserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectserviceApplication.class, args);
    }

}
