package com.luv2code.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext  context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get Bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		List<Account> accounts=accountDAO.findAccounts();
		
		System.out.println("\n Main prog");
		System.out.println("\n Accounts \n");
		for(Account temp :accounts)
		{
			System.out.println(temp.getName() +" : "+temp.getLevel());
		}
		
		context.close();
	}

}
