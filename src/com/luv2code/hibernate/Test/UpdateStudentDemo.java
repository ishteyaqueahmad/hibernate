package com.luv2code.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session object to save data
		try {
			session=factory.getCurrentSession();
			
			int studentId=1;
			
			// start a transaction
			session.beginTransaction();
			
			//update student object
			System.out.println("\nGetting student id :"+studentId);
			Student theStudent=session.get(Student.class, studentId);
			
			System.out.println("Updating Student");
			theStudent.setFirstName("ishte");

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done");

		}

		finally {
			factory.close();
		}
	}

}
