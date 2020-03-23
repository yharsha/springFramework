package com.learn.springdemo;

import org.springframework.stereotype.Component;

@Component("SillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
