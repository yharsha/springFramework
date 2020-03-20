package com.learn.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	//fields for literal injection
	private String email;
	private String team;
	//injecting value from property file
	private String owner;
	
	public void setEmail(String email) {
		System.out.println("Cricket Coach: inside setter method for email");
		this.email = email;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach: inside setter method for team");
		this.team = team;
	}
	
	public void setOwner(String owner) {
		System.out.println("Cricket Coach: inside setter method for owner");
		this.owner = owner;
	}

	//create no-arg constructor
	public  CricketCoach() {
		System.out.println("Cricket Coach - no arg constructor");
	}	
	
	//our setter method for dependency injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside stter method Fortune Service");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise fast bowling for 30 mins a day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public String getOwner() {
		return owner;
	}



}
