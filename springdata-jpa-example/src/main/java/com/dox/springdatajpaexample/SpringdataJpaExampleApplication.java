package com.dox.springdatajpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages ="com.dox.springdatajpaexample.modal")
@EnableResourceServer
public class SpringdataJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataJpaExampleApplication.class, args);
	}

}
