/**
 * 
 */
package com.sivalabs.jforum.services;

import javax.persistence.EntityManager;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.util.JPAUtils;
import com.sivalabs.jforum.util.Task;
import com.sivalabs.jforum.util.TxnTemplate;

/**
 * @author Siva
 *
 */
public class JForumService
{
	public void createUser(final User user)
	{
		final EntityManager em = JPAUtils.getEntityManager();
		TxnTemplate.build().doInTransaction(em, new Task<Object>()
		{
			@Override
			public Object execute()
			{
				em.persist(user);
				return null;
			}
		});
	}
}
