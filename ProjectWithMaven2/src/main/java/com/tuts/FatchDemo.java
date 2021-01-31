package com.tuts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FatchDemo {
	
	public static void main(String[] args) {
		
		//get ,load
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		//get student:103
		
		Student student=(Student)session.load(Student.class, 103);
		System.out.println(student);
		
		Address ad=(Address)session.get(Address.class, 1);
		System.out.println(ad.getStreet()+ " "+ad.getCity());
		
		
		
		
	}

}
