package com.dox.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dox.aopdemo.dao.AccountDAO;
import com.dox.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAccount(new Account(),true);
		
		theAccountDAO.doWork();
		
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		
		//get the Memebership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO",MembershipDAO.class);
		
		
		theMembershipDAO.addNewMember();
		
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
