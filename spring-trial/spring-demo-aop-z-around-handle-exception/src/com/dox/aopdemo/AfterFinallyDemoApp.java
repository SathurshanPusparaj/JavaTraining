package com.dox.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dox.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call method to find accounts
		List<Account> theAccounts = null;
		
		try {
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccount(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\nMain program...caught exception:"+exc);
		}
		
		System.out.println("\nMain Program: AfterThrowingDemoApp\n-------");
		System.out.println(theAccounts);
		
		
		//close the context
		context.close();
	}

}
