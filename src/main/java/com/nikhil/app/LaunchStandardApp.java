package com.nikhil.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.userinfo;

public class LaunchStandardApp {

	public static void main(String[] args) 
	{
		Configuration config=null;
		SessionFactory sessionfactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		config=new Configuration();
		
		config.configure();
		
		sessionfactory=config.buildSessionFactory();
		
		session=sessionfactory.openSession();
		
		
		userinfo user=new userinfo();
		user.setUid(4);
		user.setUname("Uttika");
		user.setUcity("Korba");
		try 
		{
			transaction=session.beginTransaction();
			session.persist(user);
			flag=true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag==true)
			{
				transaction.commit();
			}
			else
			{
				transaction.rollback();
			}
			session.close();
			sessionfactory.close();
		}

	}

}
