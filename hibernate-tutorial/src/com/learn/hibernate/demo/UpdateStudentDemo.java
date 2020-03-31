package com.learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;



public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = sessionFactory.getCurrentSession();
		
		try {
			int studentId=1;
			
			//new session for tramnsaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student temp = session.get(Student.class, studentId);
			
			System.out.println("Update student to database.."+temp);
			temp.setFirstName("Harsha");
			
			
			session.getTransaction().commit();
			
			//NEW CODE - Email update query
			session= sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email to all student");
			
			session.createQuery("update Student set email='student@edu.com'")
			.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done...!");
			//
		}
		finally {
			sessionFactory.close();
		}
	}

}
