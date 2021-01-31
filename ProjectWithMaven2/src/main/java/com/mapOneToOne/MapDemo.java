package com.mapOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();
	        
	        //create question
	        Question q1=new Question();
	        q1.setQuestion_id(1212);
	        q1.setQuestion("what is java?");
	        
	        //creating answer
	        Answer answer=new Answer();
	        answer.setAnswerId(343);
	        answer.setAnswer("Java is programming language");
	        answer.setQuestion(q1);
	     //   q1.setAnswer(answer);
	        
	      //create question
	        Question q2=new Question();
	        q2.setQuestion_id(242);
	        q2.setQuestion("what is Collection framework?");
	        
	        //creating answer
	        Answer answer1=new Answer();
	        answer1.setAnswerId(344);
	        answer1.setAnswer("ApI to work with object");
	        answer1.setQuestion(q2);
	      //  q2.setAnswer(answer1);
	        
	        
	        Session s=factory.openSession();
	        Transaction tx=s.beginTransaction();
	        
	        //save
	        s.save(q1);
	        s.save(q2);
	        s.save(answer);
	        s.save(answer1);
	        
	        
	        tx.commit();
	        
	        //fetching 
	        Question newQ=(Question)s.get(Question.class, 1212);
	        System.out.println(newQ.getQuestion());
	      //  System.out.println(newQ.getAnswer().getAnswer());
	        s.close();
	        
	        
	        
	        
	        
	        factory.close();
		
		
	}

}
