package com.learn.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
			return "From RestFortuneService...good luck ";
	}

}
