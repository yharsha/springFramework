package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;
import com.luv2code.springdemo.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//@PostContruct ..to load only once after bean is loaded
	public List<Student> students;
	@PostConstruct
	public void loadData()
	{
		students = new ArrayList<Student>();
		Student student1 = new Student("John","M");
		Student student2 = new Student("Ram","Sri");
		

		students.add(student1);
		students.add(student2);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{

		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId)
	{
		
		if((studentId>=students.size()) || studentId<0 )
		{
			throw new StudentNotFoundException("Student id not Found - "+ studentId);
		}
			
		return students.get(studentId);
	}
	
	
}
