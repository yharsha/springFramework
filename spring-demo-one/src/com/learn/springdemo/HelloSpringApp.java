package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean spring container
		Coach theCoach =context.getBean("myCoach", Coach.class);
		//call methods on beans
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
