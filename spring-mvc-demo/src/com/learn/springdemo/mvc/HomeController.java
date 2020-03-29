package com.learn.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		//view name /WEB-INF/view/main-menu.jsp
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String  showForm()
	{
		return "helloworld-form";
	}
	
}
