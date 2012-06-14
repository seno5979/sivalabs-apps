/**
 * 
 */
package com.sivalabs.jforum.web.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.services.UserService;
import com.sivalabs.jforum.web.forms.LoginForm;
import com.sivalabs.jforum.web.validation.ValidationGroups;

/**
 * @author skatam
 *
 */
//@Controller
//@RequestMapping("/rest/")
public class UserRestController 
{
	@Inject
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/xml")
	@ResponseBody
	public User login(@Valid LoginForm loginRequest) {
		System.out.println(loginRequest.getUserName()+":"+loginRequest.getPassword());
		User user = userService.login(loginRequest.getUserName(), loginRequest.getPassword());
		return user;
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST, produces="application/xml")
	@ResponseBody
	public User createUser(@Validated(value=ValidationGroups.CreateUser.class) User user) {
		User savedUser = userService.saveUser(user);
		return savedUser;
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.PUT, produces="application/xml")
	@ResponseBody
	public User updateUser(@Validated(value=ValidationGroups.UpdateUser.class) User user) {
		User savedUser = userService.saveUser(user);
		return savedUser;
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.DELETE, produces="application/xml")
	@ResponseBody
	public String deleteUser(@Validated(value=ValidationGroups.DeleteUser.class) User user) {
		userService.deleteUser(user);
		return "<status>success</status>";
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET, produces="application/xml")
	@ResponseBody
	public User getUser(@RequestParam("userId") int userId) {
		return userService.getUser(userId);
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET, produces="application/xml")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
