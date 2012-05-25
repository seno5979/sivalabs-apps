/**
 * 
 */
package com.sivalabs.jforum.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * @author Siva
 *
 */
@Singleton
public class JForumEntityManager
{
	@PersistenceContext(unitName="jforum", type=PersistenceContextType.TRANSACTION)
	protected EntityManager em;
	
	public EntityManager getEntityManager()
	{
		return em;
	}
}
