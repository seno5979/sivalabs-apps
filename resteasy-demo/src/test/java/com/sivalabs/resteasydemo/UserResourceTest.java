package com.sivalabs.resteasydemo;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;
import org.junit.Assert;
import org.junit.Test;

import com.sivalabs.resteasydemo.User;

public class UserResourceTest {

	static final String ROOT_URL = "http://localhost:8080/resteasy-demo/rest/";

	@Test
	public void testGetUsers() throws Exception 
	{
		ClientRequest request = new ClientRequest(ROOT_URL+"users/");
		request.accept("application/xml");
		ClientResponse<List<User>> response = request.get(new GenericType<List<User>>(){});
		List<User> users = response.getEntity();
		System.out.println(users);
		Assert.assertNotNull(users);
	}

	@Test
	public void testGetUserById() throws Exception 
	{
		ClientRequest request = new ClientRequest(ROOT_URL+"users/1");
		request.accept("application/xml");
		ClientResponse<User> response = request.get(User.class);
		User user = response.getEntity();
		System.out.println(user);
		Assert.assertNotNull(user);
	}

	@Test
	public void testSaveUser() throws Exception 
	{
		User user = new User();
		user.setId(3);
		user.setName("User3");
		user.setEmail("user3@gmail.com");

		ClientRequest request = new ClientRequest(ROOT_URL+"users/");
		request.accept("application/xml");
		request.body("application/xml", user);
		ClientResponse<String> response = request.post(String.class);

		String statusXML = response.getEntity();
		System.out.println(statusXML);
		Assert.assertNotNull(statusXML);
	}

	@Test
	public void testDeleteUser() throws Exception 
	{
		ClientRequest request = new ClientRequest(ROOT_URL+"users/2");
		request.accept("application/xml");
		ClientResponse<String> response = request.delete(String.class);
		String statusXML = response.getEntity();
		System.out.println(statusXML);
		Assert.assertNotNull(statusXML);
	}
}