package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aop.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account,boolean vip)
	{
		System.out.println(getClass()+"Doing DB work : adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+"Doing DB work : doWork");
		return true;
	}

}
