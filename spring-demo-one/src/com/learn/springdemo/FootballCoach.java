package com.learn.springdemo;

public class FootballCoach implements Coach {

	//define private field for dependency
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public  FootballCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise hitting goal shoutouts for 3 hours";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
