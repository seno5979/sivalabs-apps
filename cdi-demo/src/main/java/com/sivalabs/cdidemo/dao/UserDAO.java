/**
 * 
 */
package com.sivalabs.cdidemo.dao;

import java.util.List;

import com.sivalabs.cdidemo.entities.User;


/**
 * @author Siva
 *
 */
public interface UserDAO
{
	Integer create(User user);
	List<User> getAllUsers();
	User getUserById(int id);
	void update(User user);
	void delete(User user);
}
