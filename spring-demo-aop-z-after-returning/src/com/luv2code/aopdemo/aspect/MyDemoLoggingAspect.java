package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	//new Advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void AfterReturningFindAccounts(JoinPoint joinPoint,List<Account> result)
	{
		//print out method
		String method=joinPoint.getSignature().toShortString();
		System.out.println("\n ****** Executing AfterReturning method ****"+method);
		
		
		if(!result.isEmpty())
		{
			Account temp = result.get(0);
			temp.setName("Daffy");
			temp.setLevel("Daffy Silver");
		}
		//print out result
		System.out.println("\n Result"+result.toString());
	}

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
