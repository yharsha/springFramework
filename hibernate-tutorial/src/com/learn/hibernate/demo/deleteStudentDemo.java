package com.learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;



public class deleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session 
		Session session = sessionFactory.getCurrentSession();
		
		try {
			int studentId=3;
			
			//new session for tramnsaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student temp = session.get(Student.class, studentId);
			
			System.out.println("Delete student from database.."+temp);
			
			session.delete(temp);
			
			session.getTransaction().commit();
			
			//NEW CODE - Email update query
			session= sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("delete student by query");
			
			session.createQuery("delete Student where id=3")
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
