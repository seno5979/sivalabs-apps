/**
 * 
 */
package com.sivalabs.jforum.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.sivalabs.jforum.dao.CrudServiceBean;
import com.sivalabs.jforum.dao.JForumEntityManager;
import com.sivalabs.jforum.entities.User;

/**
 * @author Siva
 *
 */
@Stateless
public class UserServiceBean extends CrudServiceBean<User>
{
	
	/*@PersistenceContext(unitName="jforum", type=PersistenceContextType.EXTENDED)
	protected EntityManager em;*/
	@EJB
	private JForumEntityManager jForumEntityManager;
	
	@Override
	public EntityManager getEntityManager()
	{
		return jForumEntityManager.getEntityManager();
	}
	
	public UserServiceBean()
	{
		super(User.class);
	}

	/*
	@PersistenceContext(unitName="jforum", type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	public Integer save(User user)
	{
		em.persist(user);
		return user.getUserId();
	}
	
	public List<User> findAllUsers()
	{
		CriteriaQuery<User> createQuery = em.getCriteriaBuilder().createQuery(User.class);
		return em.createQuery(createQuery).getResultList();
	}
	
	public User findUserById(Integer userId)
	{
		return em.find(User.class, userId);
	}
	
	public void update(User user)
	{
		em.merge(user);
	}
	
	public void delete(User user)
	{
		em.remove(user);
	}
	public void delete(Integer userId)
	{
		User user = this.findUserById(userId);
		if(user !=null){
			em.remove(user);
		}
	}
	*/
	public User login(String userName, String password)
	{
		TypedQuery<User> query = this.getEntityManager().createQuery("select u from User u where u.userName=?1 and u.password=?2", User.class);
		query.setParameter(1, userName);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}

	public void changePassword(Integer userId, String newPassword)
	{
		findByID(userId).setPassword(newPassword);		
	}
}
