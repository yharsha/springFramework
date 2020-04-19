package com.learn.springBootDemo.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World to you at timestamp: "+LocalDateTime.now();
	}

}
