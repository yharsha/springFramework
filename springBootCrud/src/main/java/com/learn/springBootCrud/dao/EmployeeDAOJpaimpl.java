package com.learn.springBootCrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.learn.springBootCrud.entity.Employee;

//EntityManager + Standard JPA
@Repository
@Primary
public class EmployeeDAOJpaimpl implements EmployeeDAO{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findall() {
		
		//create a query
		Query query = entityManager.createQuery("from Employee");
		
		List<Employee> employees=query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		
		
		//create a query
		Employee employee = entityManager.find(Employee.class,id);
		
		return employee;
		
	}

	@Override
	public void save(Employee employee) {
				
				//create a query - id is 0 update else insert
		entityManager.merge(employee);
		
	}

	@Override
	public void deleteById(int id) {
	
		
		Query query = entityManager.createQuery(
				"delete from Employee where id=:theId");
		query.setParameter("theId", id);
		
		query.executeUpdate();
		
	}

}
