package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aop.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//method:find accounts
	
	public List<Account> findAccounts()
	{
		List<Account> accounts = new ArrayList<Account>();
		
		//create sample aacounts
		Account account1 = new Account("John","silver");
		Account account2 = new Account("jeane","silver");
		Account account3 = new Account("Demartini","silver");
		
		accounts.add(account3);
		accounts.add(account2);
		accounts.add(account1);
		return accounts;
				
	}
	
	public void addAccount(Account account,boolean vip)
	{
		System.out.println(getClass()+"Doing DB work : adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+"Doing DB work : doWork");
		return true;
	}

	public String getName() {
		System.out.println(getClass()+" : getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" : setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" : getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	  
}
