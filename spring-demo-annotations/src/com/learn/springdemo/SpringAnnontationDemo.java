package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnontationDemo {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		//get the bean	
	//	Coach theCoach = context.getBean("SillyCoach", Coach.class);
		//default bean id
		Coach theCoach = context.getBean("soccerCoach", Coach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		//close context
		context.close();
	}

}
