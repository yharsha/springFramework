package com.learn.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemo {

	public static void main(String[] args) {
		//load config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean
		Coach theCoach = context.getBean("soccerCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("soccerCoach", Coach.class);
		
		//bean methods
		System.out.println("Adress of  theCoach object "+theCoach);
		
		System.out.println("Adress of alphaCoach object "+alphaCoach);
		
		//close context
		context.close();
	}

}
