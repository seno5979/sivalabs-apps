/**
 * 
 */
package com.sivalabs.jforum.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.jforum.web.forms.LoginRequest;
import com.sivalabs.jforum.web.forms.UserForm;
import com.sivalabs.jforum.web.validation.ValidationGroups;

/**
 * @author skatam
 *
 */
@Controller
public class UserController 
{
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces="application/xml")
	@ResponseBody
	public String login(@Valid LoginRequest loginRequest) {
		System.out.println(loginRequest.getUserName()+":"+loginRequest.getPassword());
		return "<status>success</status>";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST, produces="application/xml")
	@ResponseBody
	public String createUser(@Validated(value=ValidationGroups.CreateUser.class) UserForm userForm) {
		System.out.println(userForm);
		return "<status>success</status>";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.PUT, produces="application/xml")
	@ResponseBody
	public String updateUser(@Validated(value=ValidationGroups.UpdateUser.class) UserForm userForm) {
		System.out.println(userForm);
		return "<status>success</status>";
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.DELETE, produces="application/xml")
	@ResponseBody
	public String deleteUser(@Validated(value=ValidationGroups.DeleteUser.class) UserForm userForm) {
		System.out.println(userForm);
		return "<status>success</status>";
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET, produces="application/xml")
	@ResponseBody
	public UserForm getUser(@RequestParam("userId") int userId) {
		System.out.println(userId);
		UserForm userForm = UserForm.createDummyUser(userId);
		return userForm;
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET, produces="application/xml")
	@ResponseBody
	public List<UserForm> getUsers() {
		List<UserForm> users = new ArrayList<UserForm>();
		for (int i = 0; i < 5; i++) {
			UserForm userForm = UserForm.createDummyUser(i);
			users.add(userForm);
		}
		return users;
	}
}
