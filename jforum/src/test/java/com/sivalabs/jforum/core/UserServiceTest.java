package com.sivalabs.jforum.core;

import java.util.List;

import javax.inject.Inject;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/jforum-context.xml"})
public class UserServiceTest
{
	@Inject
	private UserService userService;
	
	@Test
	public void testGetUsers()
	{
		List<User> users = userService.getUsers();
		for (User user : users)
		{
			System.err.println(user);
		}
	}
}
