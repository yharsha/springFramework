package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student("John","M");
		Student student2 = new Student("Ram","Sri");
		
		students.add(student1);
		students.add(student2);
		
		
		return students;
	}

}
