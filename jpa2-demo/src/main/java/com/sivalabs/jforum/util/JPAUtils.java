/**
 * 
 */
package com.sivalabs.jforum.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Siva
 *
 */
public class JPAUtils
{
	private static EntityManagerFactory EMF = buildEntityManagerFactory();
	public JPAUtils()
	{
	}
	private static EntityManagerFactory buildEntityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("jforum");
	}
	
	public static EntityManager getEntityManager()
	{
		return EMF.createEntityManager();
	}
	
	
}
