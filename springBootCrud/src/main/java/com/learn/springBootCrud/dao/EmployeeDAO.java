package com.learn.springBootCrud.dao;

import java.util.List;

import com.learn.springBootCrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findall();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
}
