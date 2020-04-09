package com.luv2code.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext  context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get Bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call business method
		Account account = new Account();
		accountDAO.addAccount(account,true);
		accountDAO.doWork();
		//close the context
		
		
		//System.out.println("\n Add account again");
		System.out.println("\n");
		
		//get Bean for membership dao
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		//call business method
		membershipDAO.addAccount1();
		membershipDAO.goToSleep();
		
		context.close();
	}

}
