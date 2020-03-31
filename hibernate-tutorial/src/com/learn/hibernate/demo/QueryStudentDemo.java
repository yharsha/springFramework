package com.learn.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learn.hibernate.entity.Student;


public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
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
			
			//start transaction
			session.beginTransaction();
			
			//HQL-hibernate query language
			//query1 get Students
			List<Student> students = session.createQuery("from Student").getResultList();
			 
			//display students
			System.out.println("-------Displaying students...---");
			displayStudents(students);
			
			//query2  get Students
			
			students = session.createQuery("from Student s where s.lastName='B'").getResultList();
			//display students
			System.out.println("-------Displaying students  where s.lastName='B'...---");
			displayStudents(students);
			
			
			//query3  get Students
			System.out.println();
			students = session.createQuery("from Student s where s.lastName='B' OR s.firstName='A'").getResultList();
			//display students
			System.out.println("-------Displaying students  where s.lastName='B' OR s.firstName='A'...---");
			displayStudents(students);
			
			
			//query3  get Students
			System.out.println();
			students = session.createQuery("from Student s where s.email LIKE '%@l.com' ").getResultList();
			//display students
			System.out.println("-------Displaying students  where s.email LIKE '%@l.com'..---");
			displayStudents(students);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done...!!");
			
		}
		finally {
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student student:students)
		{
			System.out.println(student);
		}
	}

}
