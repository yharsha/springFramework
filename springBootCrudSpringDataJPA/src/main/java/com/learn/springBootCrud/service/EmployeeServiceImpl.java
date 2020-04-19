package com.learn.springBootCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springBootCrud.dao.EmployeeRepositry;
import com.learn.springBootCrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepositry employeeRepositry;

	@Override
	public List<Employee> findall() {
		return employeeRepositry.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepositry.findById(id);
		
		Employee employee = null;
		if(result.isPresent())
		{
			 employee=result.get();
			 return employee;
		}
		else {
			throw new RuntimeException("Didnt find employee id of :" +id);
		}
		
	}

	@Override
	public void save(Employee employee) {
		employeeRepositry.save(employee);

	}

	@Override
	public void deleteById(int id) {
		employeeRepositry.deleteById(id);
	}

}
