package com.nikhil.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;

public class LaunchFirstApp {

	
	public static void main(String[] args) 
	{
		//Step 1- Configuration Object
		Configuration config=new Configuration();
		
		//Step 2- Configuration hibernate.cfg.xml file to Configuration Object
		config.configure();
		
		//Step 3- Create SessionFactory Object
		SessionFactory sessionfactory=config.buildSessionFactory();
		
		//Step 4- Get the Session object from the session factory
		Session session = sessionfactory.openSession();
		
		//Step 5- Begin the Transaction within Session
		Transaction transaction=session.beginTransaction();
		userinfo user=new userinfo();
		user.setUid(3);
		user.setUname("Ritu");
		user.setUcity("Bilaspur");
		
		//Step 6- Perform Operation
		//session.save(user);
		
		//Step 7- Performing Transaction Operation
		transaction.commit();
		
		//Step 8- Close the Resources
		session.close();
		
		
		
		
		
		
		
		
		
		
	}

}
