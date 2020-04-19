package com.learn.springBootCrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springBootCrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	
	public List<Employee> findall() {
		
		//get hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		
		List<Employee> employees=query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		//get hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create a query
		Employee employee = session.get(Employee.class,id);
		
		
		return employee;
		
	}

	@Override
	public void save(Employee employee) {
		//get hibernate session
				Session session = entityManager.unwrap(Session.class);
				
				//create a query - id is 0 update else insert
				session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery(
				"delete from Employee where id=:theId");
		query.setParameter("theId", id);
		
		query.executeUpdate();
		
	}

}
