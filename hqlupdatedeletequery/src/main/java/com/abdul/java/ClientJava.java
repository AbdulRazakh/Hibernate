/**
 * 
 */
package com.abdul.java;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author ATS-Abdul
 *
 */
public class ClientJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		//delete operation 
		Transaction txn=session.beginTransaction();
		Query query=session.createQuery("delete from Product p where p.productId=:abdul");
		query.setParameter("abdul",121);
		int test=query.executeUpdate();
		System.out.println("test value"+test);
		txn.commit();
		System.out.println("deleted successfully");
		
		//update operation
		Transaction txn1=session.beginTransaction();
		Query query1=session.createQuery("update Product p set p.productName=:abdul where p.productId=212");
		query1.setParameter("abdul","helooooo");
		int test1=query1.executeUpdate();
		System.out.println("test value"+test1);
		txn1.commit();
		System.out.println("updated successfully.......");
		
		
		

	}

}
