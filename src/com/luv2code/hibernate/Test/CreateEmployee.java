package com.luv2code.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;


public class CreateEmployee {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session object
		Session session = factory.getCurrentSession();

		try {

			// create Employee Object
			Employee theEmployee = new Employee("EOIN", "MORGAN", "GOOGLE");

			// begin transaction
			session.beginTransaction();

			// save employee object
			System.out.println("Saving the Employee");
			session.save(theEmployee);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			session.close();
		}

	}

}
