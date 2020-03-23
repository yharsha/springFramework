package com.learn.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseRandomService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "From DatabaseRandomService...good luck ";
	}

}
