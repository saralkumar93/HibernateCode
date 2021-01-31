package com.mapOneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemoOneToMany {
	
	public static void main(String[] args) {
		
		 Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();
	        
	    /*    //create question
	        Question q1=new Question();
	        q1.setQuestion_id(1212);
	        q1.setQuestion("what is java?");
	        
	        //creating answer
	        Answer answer=new Answer();
	        answer.setAnswerId(343);
	        answer.setAnswer("Java is programming language");
	        answer.setQuestion(q1);
	        
	        Answer answer1=new Answer();
	        answer1.setAnswerId(33);
	        answer1.setAnswer("With the help of java we can create softwares");
	        answer1.setQuestion(q1);
	        
	        Answer answer2=new Answer();
	        answer2.setAnswerId(353);
	        answer2.setAnswer("java has different type of frameworks");
	        answer2.setQuestion(q1);
	        
	        List<Answer> list=new ArrayList<Answer>();
	        list.add(answer);
	        list.add(answer1);
	        list.add(answer2);
	        
	      q1.setAnswers(list);
	          */  
	        
	       Session s1=factory.openSession();
	        Transaction tx=s1.beginTransaction();
	        
	        //save
	      /* s1.save(q1);
	        s1.save(answer);
	        s1.save(answer1);
	        s1.save(answer2);*/
	        
	        
	        
	        Question q=(Question)s1.get(Question.class,1212);
	        
	        System.out.println(q.getQuestion());
	        for(Answer a:q.getAnswers()) {
	        	System.out.println(a.getAnswer());
	        }
	        tx.commit();
	        
	        
	        
	        s1.close();
	        
	        
	        
	        
	        
	        factory.close();
		
		
	}

}

	
	


