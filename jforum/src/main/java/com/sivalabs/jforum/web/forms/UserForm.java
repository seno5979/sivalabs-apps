/**
 * 
 */
package com.sivalabs.jforum.web.forms;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.sivalabs.jforum.web.validation.ValidationGroups;


/**
 * @author skatam
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserForm 
{
	@NotNull(message="UserId should not be null", 
			groups={ValidationGroups.UpdateUser.class,ValidationGroups.DeleteUser.class})
    private Integer userId;
    @NotNull(message="UserName should not be null", 
    		groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
	private String userName;
    @NotNull(message="Password should not be null", 
    		groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
	private String password;
    @NotNull(message="FirstName should not be null", 
    		groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
	private String firstName;
    private String lastName;
    private String email;
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public static UserForm createDummyUser(int userId) {
		UserForm userForm = new UserForm();
		userForm.setUserId(userId);
		userForm.setUserName("UserName"+userId);
		userForm.setPassword("password"+userId);
		userForm.setFirstName("firstName"+userId);
		userForm.setLastName(null);
		userForm.setEmail("email"+userId);
		return userForm;
	}
    
    
}
