 package com.learn.springdemo;

public class TrackCoach implements Coach {

	//define private field for dependency
	private FortuneService fortuneService;
	
	//define constructor for dependency injection
	public  TrackCoach(FortuneService fortuneService) {
		this.fortuneService=fortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		
		return "Run hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		
		return "Just Do It...!!"+fortuneService.getFortune();
	}

}
