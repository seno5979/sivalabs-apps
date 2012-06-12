/**
 * 
 */
package com.sivalabs.jforum.util;

import javax.persistence.EntityManager;

/**
 * @author Siva
 *
 */
public class TxnTemplate
{
	private TxnTemplate()
	{
	}
	
	public static TxnTemplate build()
	{
		return new TxnTemplate();
	}
		
	public <T> T doInTransaction(EntityManager em, Task<T> task)
	{
		T result = null;
		try
		{
			em.getTransaction().begin();
			result = task.execute();
			em.getTransaction().commit();
		} catch (Exception e)
		{
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
		return result;
	}
}
