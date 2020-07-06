package com.luv2code.hibernate.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class ReadEmployee {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session object to save data
		try {
		// create a student object
		System.out.println("Creating a new Student Object");
		Employee employee = new Employee("William", "Rogers", "ADOBE");

		// start a transaction
		session.beginTransaction();

		// save the student object
		System.out.println("Saving the student");
		session.save(employee);
		
		// commit the transaction
		session.getTransaction().commit();
		
		//MY NEW CODE
		
		//find out the Student's id:primary key
		System.out.println("Saved student generated id:"+employee.getId());
		
		//get a new session and start a tarnsaction
		session=factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve the student based on primary key
		System.out.println("\nGetting student with id: "+employee.getId());
		Employee myStudent1=session.get(Employee.class,employee.getId());
		System.out.println("Get completed "+myStudent1);
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Done");
		
		
		
		}
		
		 finally {
			factory.close();
		}
	}

}
