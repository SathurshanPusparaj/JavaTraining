package com.cloudbox.emsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cloudbox.models_service.models")
public class EmpserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpserviceApplication.class, args);
	}

}
