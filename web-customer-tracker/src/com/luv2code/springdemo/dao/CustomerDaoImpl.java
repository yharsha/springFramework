package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		//get the hibernate session
		Session session= sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query = session.createQuery("from Customer order by lastName"
				,Customer.class);
		
		
		//get list and return
		List<Customer> customers = query.getResultList();
		return customers;
		
	
	}


	@Override
	public void saveCustomer(Customer customer) {
		//get the hibernate session
		Session session= sessionFactory.getCurrentSession();
		
		//save customer
		session.saveOrUpdate(customer);
		
	}


	@Override
	public Customer getCustomer(int id) {
		Session session= sessionFactory.getCurrentSession();
		Customer customer= session.get(Customer.class,id);
		return customer;
	}


	@Override
	public void deleteCustomer(int id) {
		Session session= sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		query.executeUpdate();
	}

}
