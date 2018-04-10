package com.abdul.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Cheque;
import com.abdul.model.CreditCard;

public class ClientJava {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		
		//Cheque subclass Obj
		Cheque cheque=new Cheque();
		cheque.setPaymentId(10);
		cheque.setAmount(10000);
		cheque.setChequeType("draw");
		
		//CreditCard subclass Obj
		
		CreditCard creditCard=new CreditCard();
		creditCard.setPaymentId(20);
		creditCard.setAmount(20000);
		creditCard.setCreditCardType("creditcard");
		Transaction txn=session.beginTransaction();
		
		session.save(cheque);
		session.save(creditCard);
		System.out.println("saved Successfully........!!!!");
		txn.commit();
		session.close();
		sessionFactory.close();
		
	}
}
