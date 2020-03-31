package com.learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;



public class ReadStudentDemo {

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
			Student student = new Student("john", "raj", "r@l.com");
			
			//start transaction
			session.beginTransaction();
			
			//save student  object
			System.out.println("Saving student object");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done...!!");
			
			
			//now read student by studentId
			
			//new session for tramnsaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student temp = session.get(Student.class, student.getId());
			
			System.out.println("Read student from database.."+temp);
			
			session.getTransaction().commit();
			
			System.out.println("Done...!");
			//
		}
		finally {
			sessionFactory.close();
		}
	}

}
