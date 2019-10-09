package com.dox.cloud.storeauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
public class StoreAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreAuthServerApplication.class, args);
	}

}
