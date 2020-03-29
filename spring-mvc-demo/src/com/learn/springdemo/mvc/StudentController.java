package com.learn.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//preprocess every form data
	//remove leading and trailing spaces
	@InitBinder
	public  void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		//create student object
		Student student = new Student();
		
		//add student to model
		model.addAttribute("student",student);
		
		return "student-form";
	}
	@RequestMapping("/prcoessFrom")
	public String prcoessFrom(@Valid @ModelAttribute("student") Student student
			,BindingResult bindingResult)
	{
		//log input data  
		System.out.println("First name of student: "+student.getFirstName());
		if(bindingResult.hasErrors())
		{
			return "student-form";
		}
		return "student-confirmation";
	}

}
