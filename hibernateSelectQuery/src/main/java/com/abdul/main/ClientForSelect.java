package com.abdul.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ClientForSelect {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Product product=(Product) session.load(Product.class, new Integer(121));
		System.out.println("Product name"+product.getProductName());
		System.out.println("Product Price"+product.getProductPrice());
		session.close();
		sessionFactory.close();
		

	}

}
