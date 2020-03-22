package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext2.xml");
		
		//get bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		//bean methods
		Coach  alphaCoach = context.getBean("myCoach", Coach.class);
		if(alphaCoach==theCoach)System.out.println("same ..singleton confirmed");
		
		System.out.println("Mem location:" + alphaCoach);
		System.out.println("Mem location:" + theCoach);
		
		context.close();
	}

}
