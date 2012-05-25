/**
 * 
 */
package com.sivalabs.jforum.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.sivalabs.jforum.dao.CrudServiceBean;
import com.sivalabs.jforum.dao.JForumEntityManager;
import com.sivalabs.jforum.entities.Forum;
import com.sivalabs.jforum.entities.Topic;

/**
 * @author Siva
 *
 */
@Stateless
public class ForumServiceBean extends CrudServiceBean<Forum>
{

	/*@PersistenceContext(unitName="jforum", type=PersistenceContextType.EXTENDED)
	protected EntityManager em;*/
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
