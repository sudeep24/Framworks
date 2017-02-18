package com.user.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataObjectUtil 
{
		
	private static SessionFactory sessionFactory= buildSessionFactory();
	private DataObjectUtil()
	{
		
	}
	private static SessionFactory buildSessionFactory()
	{
		return new Configuration().configure().buildSessionFactory();
	}
	

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public static void shutDown()
	{
		getSessionFactory().close();
	}
}
