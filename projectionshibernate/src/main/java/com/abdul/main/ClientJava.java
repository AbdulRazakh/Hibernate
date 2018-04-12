package com.abdul.main;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Product;

public class ClientJava {
	
	public static void main(String args[]){

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		
		Criteria criteria=session.createCriteria(Product.class);
		
		criteria.setProjection(Projections.property("productName"));
		Iterator ite=criteria.list().iterator();
		while (ite.hasNext()) {
			String object = (String) ite.next();
			System.out.println("object..........."+object);
			
		}
		
		
		session.close();
		sessionFactory.close();
	}

}
