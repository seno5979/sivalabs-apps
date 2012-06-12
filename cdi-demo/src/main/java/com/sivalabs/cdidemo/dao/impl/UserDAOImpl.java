/**
 * 
 */
package com.sivalabs.cdidemo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sivalabs.cdidemo.dao.UserDAO;
import com.sivalabs.cdidemo.entities.User;

/**
 * @author Siva
 *
 */

@Stateless
public class UserDAOImpl implements UserDAO
{
	@PersistenceContext
    private EntityManager entityManager;
	
	public UserDAOImpl()
	{
		System.out.println("------------UserDAOImpl()------------");
	}
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Integer create(User user)
	{
		entityManager.persist(user);
		entityManager.flush();
		return user.getUserId();
	}

	@Override
	public List<User> getAllUsers()
	{
		return this.entityManager.createQuery("select u from User u",User.class).getResultList();
	}

	@Override
	public User getUserById(int id)
	{
		return this.entityManager.find(User.class, id);
	}

	@Override
	public void update(User user)
	{
		this.entityManager.merge(user);
	}

	@Override
	public void delete(User user)
	{
		this.entityManager.remove(user);
	}

}
