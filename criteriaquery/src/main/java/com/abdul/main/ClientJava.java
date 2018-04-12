package com.abdul.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
		Criterion con=Restrictions.gt("productPrice", new Double(10000));
		criteria.add(con);
		List list=criteria.list();
		Iterator itr=list.iterator();
		while (itr.hasNext()) {
			Product object = (Product) itr.next();
			System.out.println("product id"+object.getProductid());
			System.out.println("product Name"+object.getProductName());
			System.out.println("product Price"+object.getProductPrice());
			
		}
		session.close();
		sessionFactory.close();
		
	}

}
