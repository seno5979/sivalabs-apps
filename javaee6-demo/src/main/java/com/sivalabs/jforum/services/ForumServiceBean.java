/**
 * 
 */
package com.sivalabs.jforum.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sivalabs.jforum.dao.CrudServiceBean;
import com.sivalabs.jforum.dao.JForumEntityManager;
import com.sivalabs.jforum.entities.Forum;

/**
 * @author Siva
 *
 */
@Stateless
public class ForumServiceBean extends CrudServiceBean<Forum>
{

	@Inject
	private JForumEntityManager jForumEntityManager;
	
	@Override
	public EntityManager getEntityManager()
	{
		return jForumEntityManager.getEntityManager();
	}
	
	public ForumServiceBean()
	{
		super(Forum.class);
	}

}
