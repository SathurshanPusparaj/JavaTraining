package com.dox.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dox.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\nMain program:AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripwire = true;
		String data = theFortuneService.getFortune(tripwire);
		
		myLogger.info("\n My fortune is :"+data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}

}
