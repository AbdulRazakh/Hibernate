package com.abdul.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Product;

public class ClientJava {

	public static void main(String[] args) {

		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Product product=new Product();
		product.setProductId(101);
		product.setPrice(20000);
		product.setProName("Hellloo");
		
		Transaction txn=session.beginTransaction();
		session.save(product);
		System.out.println("Saved successfully......");
		txn.commit();
		session.close();
		sessionFactory.close();

	}

}
