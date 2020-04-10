package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public String addAccount1()
	{
		System.out.println(getClass()+"Doing DB work : adding an**  Membership account **stuff");
		return "a";
	}
	
	public boolean goToSleep() {
		System.out.println(getClass()+" Memebership : goToSleep");
		return true;
	}

}
