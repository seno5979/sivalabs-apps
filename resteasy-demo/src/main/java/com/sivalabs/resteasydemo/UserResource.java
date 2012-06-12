package com.sivalabs.resteasydemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Path("/users")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
@Component
public class UserResource 
{
	@Autowired
	private UserService userService;

	@Path("/")
	@GET
	public Response getUsersXML() 
	{
		List<User> users = userService.getAll();
		GenericEntity<List<User>> ge = new GenericEntity<List<User>>(users){};
		return Response.ok(ge).build();
	}

	@Path("/{id}")
	@GET
	public Response getUserXMLById(@PathParam("id") Integer id) 
	{
		if(id==null || id < 1 ){
			throw new ApplicationException("User Id["+id+"] should not be less than 1.");
		}
		User user = userService.getById(id);
		
		if(user==null ){
			throw new ResourceNotFoundException("No User found with Id :["+id+"]");
		}
		return Response.ok(user).build();
	}

	@Path("/")
	@POST
	public Response saveUser(User user) {
		userService.save(user);
		return Response.ok("<status>success</status>").build();
	}

	@Path("/{id}")
	@DELETE
	public Response deleteUser(@PathParam("id") Integer id) {
		userService.delete(id);
		return Response.ok("<status>success</status>").build();
	}

}