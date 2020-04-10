package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aop.Account;

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
	public void beforeAddAccountAdvice(JoinPoint joinpoint)
	{
		System.out.println("\n=======>>> Executing @Before Advice(\"execution(public void addAccount()\")  <=====");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
		System.out.println("methodSignature: "+methodSignature);
		
		//display method arguements
		Object[] args = joinpoint.getArgs();
		
		for(Object temp:args)
		{
			System.out.println(temp);
			if(temp instanceof Account)
			{
				//downcast
				Account account= (Account)temp;
				System.out.println("account name:..."+account.getName());
				System.out.println("account level:..."+account.getLevel());
			}
		}
	}
	


}
