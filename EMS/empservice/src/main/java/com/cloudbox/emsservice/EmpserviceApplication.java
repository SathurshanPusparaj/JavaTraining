package com.cloudbox.emsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class EmpserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpserviceApplication.class, args);
	}

}
