package com.sivalabs.dashboard.bo;
import javax.ejb.Local;

import com.sivalabs.dashboard.model.User;

@Local
public interface UserServiceEJBLocal {
	
	public String sayHello(String name);

	User login(String username, String password);
}
