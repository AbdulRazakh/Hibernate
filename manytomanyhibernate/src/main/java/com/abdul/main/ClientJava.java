package com.abdul.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.abdul.model.Course;
import com.abdul.model.Student;

public class ClientJava {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
	    configuration.configure("hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		Student student=new Student();
		student.setStudentId(101);
		student.setStudentName("AR");
		student.setMarks(99);
		
		Student student1=new Student();
		student1.setStudentId(102);
		student1.setStudentName("AR");
		student1.setMarks(99);
		
		Course course=new Course();
		course.setCourseId(212);
		course.setCourseName("Software");
		course.setDuration(6);
		
		Course course1=new Course();
		course1.setCourseId(112);
		course1.setCourseName("Software");
		course1.setDuration(6);
		
		/*Set s=new HashSet();
		s.add(course);
		s.add(course1);
		
		student.setCourse(s);
		student1.setCourse(s);*/
		Set s=new HashSet();
		s.add(student);
		s.add(student1);
		
		course.setStudents(s);
		course1.setStudents(s);
		Transaction txn=session.beginTransaction();
		session.save(course);
		session.save(course1);
		System.err.println("done with commit.!!!!!!!!!!");
		txn.commit();
	}

}
