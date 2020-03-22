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
	
	//add init method
	public void doMyStartupStuff()
	{
		System.out.println("Track Coah: inside doMyStartupStuff init method");
	}
	
	//add destroy method
	public void doMyCleanupStuff()
	{
		System.out.println("Track Coah: inside doMyCleanupStuff destroy method");
	}

}
