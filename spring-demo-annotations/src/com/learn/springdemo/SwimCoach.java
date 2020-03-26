package com.learn.springdemo;

import org.springframework.beans.factory.annotation.Value;

//SwimCoach - uses sadFortuneService helper/dependencies
public class SwimCoach implements Coach {

	private FortuneService FortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	public String getEmail() {
		return email;
	}
	public  SwimCoach(FortuneService fortuneService) {
		FortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim for contionous 30 mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return FortuneService.getFortune();
	}

}
