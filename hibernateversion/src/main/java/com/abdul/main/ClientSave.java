package com.abdul.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ClientSave {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Product product=new Product();
		product.setProductId(121);
		product.setProductName("arproduct");
		product.setProductPrice(20000);
		Transaction transaction=session.beginTransaction();
		session.save(product);
		System.out.println("Obeject saved successfulyy");
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("session closed successfulyy.........");
		

	}

}
