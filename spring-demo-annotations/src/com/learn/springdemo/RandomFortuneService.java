package com.learn.springdemo;

import java.util.Random;

import javax.xml.crypto.Data;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	private String[] data = {"good","better","best"};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(data.length);
		
		String fortune = data[index];
		return "From RandomService...good luck " + fortune;
	}

}
