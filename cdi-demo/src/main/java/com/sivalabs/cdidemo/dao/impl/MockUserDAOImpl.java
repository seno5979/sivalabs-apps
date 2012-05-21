/**
 * 
 */
package com.sivalabs.cdidemo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.inject.Alternative;

import com.sivalabs.cdidemo.dao.UserDAO;
import com.sivalabs.cdidemo.entities.User;

/**
 * @author Siva
 *
 */
@Alternative
public class MockUserDAOImpl implements UserDAO, Serializable
{
	private static final long serialVersionUID = 1L;
	private static final Map<Integer, User> USER_TABLE = new HashMap<Integer, User>();
	private static final AtomicInteger ID_GEN = new AtomicInteger(0);
	
	public MockUserDAOImpl()
	{
		System.out.println("------------MockUserDAOImpl()-------------");
	}
	
	@Override
	public Integer create(User user)
	{
		user.setUserId(ID_GEN.incrementAndGet());
		USER_TABLE.put(user.getUserId(), user);
		return user.getUserId();
	}

	@Override
	public List<User> getAllUsers()
	{
		return new ArrayList<User>(USER_TABLE.values());
	}

	@Override
	public User getUserById(int id)
	{
		return USER_TABLE.get(id);
	}

	@Override
	public void update(User user)
	{
		USER_TABLE.put(user.getUserId(), user);
	}

	@Override
	public void delete(User user)
	{
		USER_TABLE.remove(user.getUserId());		
	}

}
