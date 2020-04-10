package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.apache.catalina.tribes.util.StringManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//point cut decl.
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage()
	{}
	
	//for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServiceackage()
	{}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage()
	{}
	
	@Pointcut("forControllerPackage() || forServiceackage() ||forDaoPackage() ")
	private void forAppFlow()
	{}
	
	
	//add @before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinpoint)
	{
		//method name
		String method = joinpoint.getSignature().toShortString();
		logger.info("/n ** Executing @before for method: "+method);
		//method args
		
		for(Object args:joinpoint.getArgs())
		{
			logger.info("Arg: "+args);
		}
	}
	
	
	
	//add@AfterReturning
	@AfterReturning(pointcut="forAppFlow()",returning="result")
	public void afterReturning(JoinPoint joinpoint,Object result)
	{
		//method name
		String method = joinpoint.getSignature().toShortString();
		logger.info("/n ** Executing @afterReturning from method: "+method);
		
		
		//result
		logger.info("==> result:"+result);

	}

}
