package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		// practical of hibernate states
		//Transient
		//Persistent
		//Detached
		//Removed
		
		System.out.println("Example : ");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student=new Student();
		student.setId(1414);
		student.setName("peter");
		student.setCity("mumbai");
		student.setCerti(new Certificate("java hibernate cource","2 month"));
		
		//student : transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//student : persistent -session,database
		
		tx.commit();
		f.close();
		
		
	}
}
