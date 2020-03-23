package com.learn.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


//for default bean id...sam as class with first letter as lower class
@Component
public class SoccerCoach implements Coach {
	
	private FortuneService FortuneService;

	public SoccerCoach() {
		super();
		System.out.println("Inside SoccerCoach :no-arg default constructor");
	}

	//define setter method
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside SoccerCoach :Setter Method setFortuneService...");
		FortuneService = fortuneService;
	}
	
	/*
	@Autowired
	public SoccerCoach(FortuneService fortuneService) {
		FortuneService = fortuneService;
	}
	*/
	
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice defence for 20 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return FortuneService.getFortune();
	}

}
