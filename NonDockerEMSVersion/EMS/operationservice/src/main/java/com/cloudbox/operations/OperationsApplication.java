package com.cloudbox.operations;

import com.cloudbox.operations.Service.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
@EnableResourceServer
public class OperationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperationsApplication.class, args);

    }

}
