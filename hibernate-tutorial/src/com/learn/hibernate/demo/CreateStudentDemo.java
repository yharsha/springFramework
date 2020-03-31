package com.learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = sessionFactory.getCurrentSession();
		
		try {
			//use session object to
			//create Student object
			System.out.println("creating stident object..");
			Student student = new Student("Ram", "lalla", "r@l.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student  object
			System.out.println("Saving student object");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done...!!");
			
		}
		finally {
			sessionFactory.close();
		}
	}

}
