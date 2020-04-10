package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all related advices for logging
	
	//lets start with an @Before advice
	
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*())")
	
	//@Before("execution(* add*(..))")
	/**
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=======>>> Executing @Before Advice(\"execution(public void addAccount()\")  <=====");
	}
	**/
	
	//point cut decleration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}
	
	
	//create point cut for getter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter()
	{}
	
	
	//create point cut for getter
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter()
	{}
	
	
	//create point cut : include package exclude getter adn setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void inclusiveNoGetterSetter()
	{}
	
	//Applying pointcut to advices 
	@Before("inclusiveNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=======>>> Executing @Before Advice(\"execution(public void addAccount()\")  <=====");
	}
	
	
	@Before("inclusiveNoGetterSetter()")
	public void performAPIAnalytics()
	{
		System.out.println("\n=======>>>  performAPIAnalytics  <=====");
	}
	
	@Before("inclusiveNoGetterSetter()")
	public void logToCloud()
	{
		System.out.println("\n=======>>>  logToCloud  <=====");
	}

}
