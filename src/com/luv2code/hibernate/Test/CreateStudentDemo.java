package com.luv2code.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session object to save data
		try {
		// create a student object
		System.out.println("Creating a new Student Object");
		Student student = new Student("Mark", "Taylor", "mark.taylor@gmail.com");

		// start a transaction
		session.beginTransaction();

		// save the student object
		System.out.println("Saving the student");
		session.save(student);
		
		// commit the transaction
		session.getTransaction().commit();
		System.out.println("Done");
		}
		
		 finally {
			factory.close();
		}
	}

}
