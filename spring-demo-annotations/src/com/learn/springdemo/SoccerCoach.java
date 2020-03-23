package com.learn.springdemo;

import org.springframework.stereotype.Component;


//for default bean id...sam as class with first letter as lower class
@Component
public class SoccerCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice defence for 20 mins";
	}

}
