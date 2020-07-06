package com.luv2code.hibernate.Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session object to save data
		try {

			// start a transaction
			session.beginTransaction();
			
			//Query the student
			List<Student> theStudent=session.createQuery("from Student").list();
			
			// display the student
			for(Student tempStudent:theStudent) {
				System.out.println(tempStudent);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}

		finally {
			factory.close();
		}
	}

}
