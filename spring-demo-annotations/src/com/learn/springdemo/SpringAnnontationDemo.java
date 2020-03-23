package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnontationDemo {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		//get the bean	
		TennisCoach theCoach = context.getBean("SillyCoach", TennisCoach.class);
		//default bean id
		Coach theCoach1 = context.getBean("soccerCoach", Coach.class);
		
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		//value injection
		System.out.println(theCoach.getEmail());
		
		//setter autowiring
		System.out.println("---- SoccerCoach ----");
		System.out.println(theCoach1.getDailyWorkout());
		
		System.out.println(theCoach1.getDailyFortune());
		
		//close context
		context.close();
	}

}
