package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAsyncAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.inclusiveNoGetterSetter()")
	public void logToCloud()
	{
		System.out.println("\n=======>>>  logToCloud in Async fashion <=====");
	}


}
