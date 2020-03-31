package com.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcurl = 
				"jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimeZone=UTC";
		
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("Connecting to database: "+jdbcurl);
			Connection myConnection = DriverManager.getConnection(jdbcurl, user, password);
			
			System.out.println("Connecting successful");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
