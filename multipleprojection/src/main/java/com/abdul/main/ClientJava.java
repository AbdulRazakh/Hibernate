package com.abdul.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
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
		
		
		ProjectionList projectionList=Projections.projectionList();
		projectionList.add(Projections.property("productName"));
		projectionList.add(Projections.property("productPrice"));
		criteria.setProjection(projectionList);
		
		List  list=criteria.list();
		Iterator itr=list.iterator();
		while (itr.hasNext()) {
			Object  obj[] = (Object[]) itr.next();
			System.out.println("obj 0"+obj[0]);
			System.out.println("obj 1"+obj[1]);
		}
		
	}

}
