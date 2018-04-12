package com.abdul.java;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ClientJava {

	public static void main(String[] args) {
		
		
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction txn=session.beginTransaction();
		Query query= session.createQuery("insert into Product(productId,productName,productPrice) "
				+ "select st.itemid, st.itemname,st.itemprice from Items st where st.itemid = 10");
		/*Query query = session.createQuery("insert into Product(productId,productName,productPrice)" +
				" select st.stockId, st.price from Stock st where st.stockId = 5");*/
		int res = query.executeUpdate();
		System.out.println("res.........."+res);
		txn.commit();
		System.out.println("Inserted Successfully!!!!!!!!!!");
		 

	}

}
