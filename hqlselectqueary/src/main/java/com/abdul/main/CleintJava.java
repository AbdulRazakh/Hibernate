package com.abdul.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Product;

public class CleintJava {

	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		
		/*select all  query*/
		Query query=session.createQuery("from Product p");
		List list=  query.list();
		Iterator iterator=list.iterator();
		
		while(iterator.hasNext()){
			Object object=iterator.next();
			Product product=(Product) object; 
			System.out.println("product id all query"+product.getProductId());
			System.out.println("product prodName all query"+product.getProductName());
			System.out.println("product Price all query"+product.getProductPrice());
			
			
		}
		System.out.println("full query 1 done");
		/*select partial query*/
		
		Query partialQuery=session.createQuery("select p.productId,p.productName from Product p");
		 @SuppressWarnings("unchecked")
		List<Object[]> partiallist=partialQuery.list();
		Iterator<Object[]> partialIterator=partiallist.iterator();
		while(partialIterator.hasNext()){
			Object[] object = partialIterator.next();
			System.out.println("object[0]"+object[0]);
			System.out.println("object[1]"+object[1]);
			
		}
		System.out.println("partial query 1 done");
		/*select single element query*/
		Query partialsingleQuery=session.createQuery("select p.productId from Product  p");
		@SuppressWarnings("unchecked")
		List<Object[]> partialsinglelist=partialsingleQuery.list();
		Iterator<Object[]> partialsingleIterator=partialsinglelist.iterator();
		while(partialsingleIterator.hasNext()){
			Object integer= partialsingleIterator.next();
			System.out.println("object[0]...."+integer);
					
		}
		System.out.println("partial query 2 done");
		
	}

}
