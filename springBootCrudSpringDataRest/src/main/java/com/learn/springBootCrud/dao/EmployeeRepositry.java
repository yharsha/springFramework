package com.learn.springBootCrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learn.springBootCrud.entity.Employee;

//members instead of /Employees
//@RepositoryRestResource(path="members")
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {
	
	//No need to write any code...all save/delete /update ,methods are free

}
