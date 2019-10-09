package com.dox.smsui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//@EnableAspectJAutoProxy
//@ComponentScan("com.dox.smsui.aop")
public class SmsUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsUiApplication.class, args);
	}

}
