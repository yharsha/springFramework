package com.learn.springdemo;

public class BaseballCoach implements Coach {
	//dependency is like helper
	//define private field for dependency
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public  BaseballCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "spend 30 mins on batting";
	}

	@Override
	public String getDailyFortune() {
		
		//use fortune service  to get Fortune
		return fortuneService.getFortune();
	}

}
