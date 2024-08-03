package com.model;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HBUtil {
public static SessionFactory sessionFactory;
public static SessionFactory buildSessionFactory()
{
		try
		{
			Configuration configuration = new Configuration();
			configuration.configure("Hibernate.cfg.xml");
			System.out.println("Hibernate Configuration loaded");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
					System.out.println("Hibernate Service Registry created");
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry );
					return sessionFactory;

		}
		catch(Throwable ex)
		{
			System.err.println("Initial SessionFactorycreation failed."+ex);
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
			}
		}
   
   public static SessionFactory getSessionFactory() {
	   if(sessionFactory == null) 
		   sessionFactory = buildSessionFactory();
	       return sessionFactory;
   }
}

