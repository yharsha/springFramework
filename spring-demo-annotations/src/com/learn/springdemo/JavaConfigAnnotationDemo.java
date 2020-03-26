package com.learn.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigAnnotationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("---------");
		System.out.println("----Without any xml file only using java class for context config-----");
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(SportConfig.class);
		
		//Coach theCoach = context.getBean("soccerCoach", Coach.class);
		
		//Coach theCoach = context.getBean("SwimCoach", Coach.class);
		
		SwimCoach theCoach = context.getBean("SwimCoach", SwimCoach.class);
		//call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail());
		
		//close
		context.close();
	}

}
