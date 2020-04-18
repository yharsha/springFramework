package com.luv2code.springdemo.controller;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
		
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId){
		
		
		Customer customer=  customerService.getCustomer(customerId);
		 
		if(customer==null)
		{
			throw new CustomerNotFoundException("Customer id not found - "+customerId);
		}
			
		return customer;
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public String deleteCustomer(@PathVariable int customerId )
	{
		Customer customer=  customerService.getCustomer(customerId);
		 
		if(customer==null)
		{
			throw new CustomerNotFoundException("Customer id not found - "+customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer id- "+customerId;
	}

}
