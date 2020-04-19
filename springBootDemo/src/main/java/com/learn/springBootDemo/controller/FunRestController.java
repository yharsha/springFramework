package com.learn.springBootDemo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachname;

	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World to you at timestamp: "+LocalDateTime.now();
	}
	
	
	@GetMapping("/teaminfo")
	public String teaminfo()
	{
		return "Coach name: "+coachname +"Team Name: " + teamName +"  %% "+LocalDateTime.now();
	}

}
