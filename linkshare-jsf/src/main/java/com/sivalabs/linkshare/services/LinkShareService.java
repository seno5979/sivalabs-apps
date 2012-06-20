package com.sivalabs.linkshare.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.sivalabs.linkshare.entities.User;

@Stateless
public class LinkShareService
{
   @PersistenceContext 
   private EntityManager em;

   public User save(User user)
	{
		em.persist(user);
		return user;
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
	
	public User login(String userName, String password)
	{
		TypedQuery<User> query = em.createQuery("select u from User u where u.userName=?1 and u.password=?2", User.class);
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
		findUserById(userId).setPassword(newPassword);
	}
   
}
