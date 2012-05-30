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
import com.sivalabs.cdidemo.interceptors.Log;


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
	
	public UserController()
	{
		System.out.println("----------UserController()------------"+this.hashCode());
	}
	@Inject
	private UserDAO userDAO;
	
	@Inject
	private Timer timer;
	
	@PostConstruct
	public void init()
	{
		System.out.println("----------UserController.init()------------"+this.hashCode());
		this.authorName = "Siva";
	}
	
	public String getAuthorName()
	{
		return authorName;
	}
	
	@Log
	public void executeTests()
	{
		System.out.println("UserController:"+this.hashCode());
		System.out.println("Timer:"+timer.hashCode());
		timer.start();
		//User u1 = new User(); u1.setUserName("admin");u1.setPassword("admin");
		//User u2 = new User(); u2.setUserName("siva"+System.currentTimeMillis());u2.setPassword("siva");
		System.out.println("UserDAO-->"+this.userDAO.hashCode());
		//userDAO.create(u1);
		//userDAO.create(u2);
		List<User> allUsers = userDAO.getAllUsers();
		for (User user : allUsers)
		{
			System.out.println(user);
		}
		timer.end();
		System.out.println("Time Taken :"+timer.getTime());
	}
}
