package com.abdul.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Product;

class ClientJava {

	public static void main(String[] args) {
		
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		
		/*select all  query*/
		Query query=session.createQuery("from Product p where p.productId=:abdul");
		query.setParameter("abdul", 121);
		List list=  query.list();
		Iterator iterator=list.iterator();
		
		while(iterator.hasNext()){
			Object object=iterator.next();
			Product product=(Product) object; 
			System.out.println("product id all query"+product.getProductId());
			System.out.println("product prodName all query"+product.getProductName());
			System.out.println("product Price all query"+product.getProductPrice());
			
			
		}
		System.out.println("first query executed!!!!!!!!!");
		
//		? is depricated in hibernate............
		/*Query questionmarkquery=session.createQuery("from Product p where p.productId=?");
		query.setParameter(1, 121);
		List questionmarklist=  questionmarkquery.list();
		Iterator questionmarkiterator=list.iterator();
		
		while(questionmarkiterator.hasNext()){
			Object object=questionmarkiterator.next();
			Product product=(Product) object; 
			System.out.println("product id all query"+product.getProductId());
			System.out.println("product prodName all query"+product.getProductName());
			System.out.println("product Price all query"+product.getProductPrice());
			
			
		}*/
		System.out.println("Second query executed......!!!!!!!!");
		
		
		session.close();
		sessionFactory.close();
		System.out.println("session closed successfulyy.........");
		
		
	}

}
