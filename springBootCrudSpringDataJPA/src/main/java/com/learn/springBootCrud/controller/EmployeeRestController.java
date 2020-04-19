package com.learn.springBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springBootCrud.entity.Employee;
import com.learn.springBootCrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return employeeService.findall();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee employee= employeeService.findById(employeeId);
		if(employee==null)
		{
			throw new RuntimeException("Empolyee id not Found: "+employeeId);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);
		employeeService.save(employee);
	}
	
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee employee)
	{
		employeeService.save(employee);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId)
	{
		Employee employee= employeeService.findById(employeeId);
		if(employee==null)
		{
			throw new RuntimeException("Empolyee id not Found: "+employeeId);
		}
		 employeeService.deleteById(employeeId);
	}
}
