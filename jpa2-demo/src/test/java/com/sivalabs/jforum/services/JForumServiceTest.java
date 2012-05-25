/**
 * 
 */
package com.sivalabs.jforum.services;

import com.sivalabs.jforum.entities.User;

/**
 * @author Siva
 *
 */
public class JForumServiceTest
{

	static JForumService forumService;
	
	public static void main(String[] args)
	{
		forumService = new JForumService();
		createUser();
		
		
	}
	
	public static void createUser()
	{
		User user = new User();
		user.setUserName("admin");
		user.setPassword("secret");
		user.setFirstName("Administrator");
		user.setLastName("");
		user.setEmail("sivaprasadreddy.k@gmail.com");
		user.setActive(true);
		
		forumService.createUser(user);
	}
}
