package com.learn.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


//without Using xml file
@Configuration
//@ComponentScan("com.learn.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	//define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}	
	//define bean for swim coach and inject dependency
	@Bean
	public Coach SwimCoach()
	{
		return new SwimCoach(sadFortuneService());
	}
	
}
