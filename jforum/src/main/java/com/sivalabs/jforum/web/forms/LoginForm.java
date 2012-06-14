/**
 * 
 */
package com.sivalabs.jforum.web.forms;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.sivalabs.jforum.web.validation.ValidationGroups;


/**
 * @author skatam
 *
 */
public class LoginForm 
{
	@NotNull(message="UserName should not be null", 
	groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
	private String userName;
	
	@NotNull(message="Password should not be null", 
	groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
