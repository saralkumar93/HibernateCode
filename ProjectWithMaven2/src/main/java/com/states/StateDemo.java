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
		Students student1=new Students();
		student1.setId(1414);
		student1.setName("peter");
		student1.setCity("mumbai");
		student1.setCerti(new Certificate("java hibernate cource","2 month"));
		
		//student : transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student1);
		//student : persistent -session,database
		
		student1.setName("john");
		
		tx.commit();
		s.close();
		//student : detached state
		student1.setName("sachin");
		System.out.println(student1);
		f.close();
		
		
	}
}
