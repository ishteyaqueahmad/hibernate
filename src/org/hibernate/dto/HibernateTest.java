package org.hibernate.dto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails details=new UserDetails();
		details.setId(1);
		details.setUserName("FirstName");
		
		details.setId(2);
		details.setUserName("YAHYA");
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(details);
		session.getTransaction().commit();
	}

}
