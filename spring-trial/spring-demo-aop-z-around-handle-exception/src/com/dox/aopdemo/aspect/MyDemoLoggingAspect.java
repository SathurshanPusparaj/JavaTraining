package com.dox.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dox.aopdemo.Account;
import com.dox.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.dox.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
				
		//print out method we are advising on
		String method =  theProceedingJoinPoint.getSignature().toString();
		myLogger.info("\n============>>> Executing @Around on method: "+method);
		//get begin time stamp
		long begin = System.currentTimeMillis();
		
		//now,let's execute the method
		Object result = null ;
				
			try {
				result = theProceedingJoinPoint.proceed();
			} catch (Exception e) {
				//log the exception
				myLogger.warning(e.getMessage());
			
				//give user a custom message
				
				result = "Major accident! But no worries,"+
				"your private AOP helicopter is on the way!";
				
				//throw e; //if any exception occurs re-throw the error
			}
		//get end time stamp
		
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		
		myLogger.info("\n========>Duration:"+duration/1000.0+" seconds");
		
		return result;
		
	}
	
	@After("execution(* com.dox.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method =  theJoinPoint.getSignature().toString();
		myLogger.info("\n============>>> Executing @After(finally) on method: "+method);
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.dox.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint,Throwable theExc) {
		//printout which method we are advising
		String method =  theJointPoint.getSignature().toString();
		myLogger.info("\n============>>> Executing @AfterReturning on method: "+method);
		
		//log the exception
		myLogger.info("\n============>>> exception is:"+theExc);
		
	}
	
	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.dox.aopdemo.dao.AccountDAO.findAccount(..))",
			returning="result"
			)
	public void afterReturningFindAccountAdvice(
			JoinPoint theJoinPoint,List<Account> result) {
		
		String method =  theJoinPoint.getSignature().toString();
		myLogger.info("\n============>>> Executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		myLogger.info("\n============>>> result is:"+result);
		
		//let's post-process the data.. let's modify is:-
		
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n============>>> result is:"+result);
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAcc:result) {
			String theUpperName = tempAcc.getName().toUpperCase();
			
			tempAcc.setName(theUpperName);
		}
		
	}


	//this is where we add all of our related advice for logging
	
	//let's start with @Before advice
	//@Before("execution(public void addAccount())") without wild card
	@Before("com.dox.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n=====>>> Executing @Before advice on method");	
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());								

			}
		}
		
	}
}
