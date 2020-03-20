package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// laod the spring config file
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrive bean form spring conatiner
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		System.out.println("owner :"+coach.getOwner());
		//close context
		context.close();
	}

}
