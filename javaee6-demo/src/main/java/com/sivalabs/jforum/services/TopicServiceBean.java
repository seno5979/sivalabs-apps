/**
 * 
 */
package com.sivalabs.jforum.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sivalabs.jforum.dao.CrudServiceBean;
import com.sivalabs.jforum.dao.JForumEntityManager;
import com.sivalabs.jforum.entities.Forum;
import com.sivalabs.jforum.entities.Topic;

/**
 * @author Siva
 *
 */
@Stateless
public class TopicServiceBean extends CrudServiceBean<Topic>
{
	
	@Inject
	private JForumEntityManager jForumEntityManager;
	
	@Override
	public EntityManager getEntityManager()
	{
		return jForumEntityManager.getEntityManager();
	}
	public TopicServiceBean()
	{
		super(Topic.class);
	}

	public List<Topic> getTopics(int forumId)
	{
		//TypedQuery<Collection> createQuery = this.em.createQuery("select f.topicList from Forum f where f.forumId=?1", Collection.class);
		//TypedQuery<Topic> createQuery = this.em.createQuery("select t from Topic t where t.forum.forumId=?1", Topic.class);
		//TypedQuery<Topic> createQuery = this.em.createQuery("SELECT t FROM Topic t JOIN t.forum f WHERE f.forumId = ?1", Topic.class);
		//createQuery.setParameter(1, forumId);
		//return createQuery.getResultList();
		//return new ArrayList<Topic>(createQuery.getResultList());
		//return new ArrayList<Topic>(createQuery.getSingleResult());
		
		/*TypedQuery<Forum> query = this.getEntityManager().createQuery("select f from Forum f where f.forumId=?1", Forum.class);
		query.setParameter(1, forumId);
		Forum forum = query.getSingleResult();
		return forum.getTopicList();*/
		
		//return this.findByID(forumId).getTopicList();
		return this.getEntityManager().find(Forum.class, forumId).getTopicList();
	}
}
