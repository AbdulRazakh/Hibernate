package com.abdul.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Customer;
import com.abdul.model.Vendor;

public class ClientJava {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Vendor parent=new Vendor();
		parent.setVendorId(101);
		parent.setVendorName("abdul");
		
		//childrens
		Customer customer=new Customer();
		customer.setCustomerId(11);
		customer.setCustomerName("A");
		
		Customer customer1=new Customer();
		customer1.setCustomerId(21);
		customer1.setCustomerName("A");
		
		Customer customer2=new Customer();
		customer2.setCustomerId(31);
		customer2.setCustomerName("A");
		
		Set s=new HashSet();
		s.add(customer);
		s.add(customer1);
		s.add(customer2);
		
		parent.setChildren(s);
		Transaction txn=session.beginTransaction();
		
		
		session.save(parent);
		txn.commit();	
		
		
		//delete operation 
		Vendor vendorparent=(Vendor) session.get(Vendor.class, new Integer(101));
		Transaction txndelete=session.beginTransaction();
		session.delete(vendorparent);
		txndelete.commit();
		
		//select operation 
		
		
		Vendor vendorselect=(Vendor) session.get(Vendor.class, new Integer(10));
		
				System.out.println("id......."+vendorselect.getVendorId());
				System.out.println("name......."+vendorselect.getVendorName());
		        Set listSet= (Set) vendorselect.getChildren();
		        
		        Iterator itr= listSet.iterator();
		        
		        while (itr.hasNext()) {
					Customer customerselect = (Customer) itr.next();
					System.out.println("customer id is "+customerselect.getCustomerId());
					System.out.println("customer name is "+customerselect.getCustomerName());
					System.out.println("customer foriegn is "+customerselect.getForeingKey());
				}
		
		
	
	}

}
