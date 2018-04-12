package com.abdul.main;

import java.util.Iterator;

import org.hibernate.Query;
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
		
		
		Query query=session.getNamedQuery("Myquery");
		query.setParameter("java4s", new Double(1000));
		Iterator itr=query.iterate();
		
		while (itr.hasNext()) {
			Product object = (Product) itr.next();
			System.out.println("product id"+object.getProductId());
			System.out.println("product Name"+object.getProductName());
			System.out.println("product price"+object.getProductPrice());
			
		}
		session.close();
		sessionFactory.close();		
	}

}
