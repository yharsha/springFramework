package com.learn.springBootCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springBootCrud.entity.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {
	
	//No need to write any code...all save/delete /update ,methods are free

}
