package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
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

	//Applying pointcut to advices 
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.inclusiveNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n=======>>> Executing @Before Advice(\"execution(public void addAccount()\")  <=====");
	}
	


}
