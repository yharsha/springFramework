package com.learn.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SillyCoach")
public class TennisCoach implements Coach {
	

	//field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService FortuneService;
	
	
	//value injection
	@Value("${foo.email}")
	private String email;
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		FortuneService = fortuneService;
	}
	*/

	public String getEmail() {
		return email;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return FortuneService.getFortune();
	}

}
