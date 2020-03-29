package com.learn.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show HTML form
	@RequestMapping("/showForm")
	public String  showForm()
	{
		return "helloworld-form";
	}
	
	//need a controller method to process HTML form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	
	//new controller method to read form date and
	// add data to model
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request,Model model)
	{
		//read request parameter from html form
		String name = request.getParameter("studentName");
		//convert data to all caps
		name=name.toUpperCase();
		//create message
		String result = "Yo!... "+ name;
		//add messgae to model
		model.addAttribute("message",result);
		
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersion3")
	public String processFormVersion3(@RequestParam("studentName") String name,Model model)
	{
		//read request parameter from html form
		//String name = request.getParameter("studentName");
		//convert data to all caps
		name=name.toUpperCase();
		//create message
		String result = "Hey My frined from v3!... "+ name;
		//add messgae to model
		model.addAttribute("message",result);
		
		
		return "helloworld";
	}
}
