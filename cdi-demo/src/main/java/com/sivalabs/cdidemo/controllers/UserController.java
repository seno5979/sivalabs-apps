/**
 * 
 */
package com.sivalabs.cdidemo.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sivalabs.cdidemo.dao.UserDAO;
import com.sivalabs.cdidemo.entities.User;


/**
 * @author Siva
 *
 */
@Named
@SessionScoped
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String authorName;
	
	@Inject
	private UserDAO userDAO;
	
	@PostConstruct
	public void init()
	{
		this.authorName = "Siva";
	}
	
	public String getAuthorName()
	{
		return authorName;
	}
	
	public void executeTests()
	{
		User u1 = new User(); u1.setUserName("admin");u1.setPassword("admin");
		User u2 = new User(); u2.setUserName("siva"+System.currentTimeMillis());u2.setPassword("siva");
		
		userDAO.create(u1);
		userDAO.create(u2);
		List<User> allUsers = userDAO.getAllUsers();
		for (User user : allUsers)
		{
			System.out.println(user);
		}
	}
}
