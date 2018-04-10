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
		
		Cheque cheque=new Cheque();
		cheque.setPaymentId(121);
		cheque.setAmount(20000);
		cheque.setChequeType("chequeType");
		
		CreditCard creditCard=new CreditCard();
		creditCard.setPaymentId(212);
		creditCard.setAmount(40000);
		creditCard.setCreditCard("creditCard");
		Transaction txn=session.beginTransaction();
		session.save(cheque);
		session.save(creditCard);
		
		txn.commit();
		session.close();
		sessionFactory.close();
		
	}

}
