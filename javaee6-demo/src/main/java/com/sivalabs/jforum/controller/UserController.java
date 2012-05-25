/**
 * 
 */
package com.sivalabs.jforum.controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.forms.ChangePwdRequest;
import com.sivalabs.jforum.services.UserServiceBean;
import com.sivalabs.jforum.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@ManagedBean
@ViewScoped
public class UserController
{
	@EJB
	private UserServiceBean userServiceBean;
	
	private String userName = "admin";
	private String password = "admin";
	
	private User user;
	private User currentUser;
	private ChangePwdRequest changePwdRequest;
	
	public String login()
	{
		User user = this.userServiceBean.login(userName, password);
		if(user == null)
		{
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage("UserName or Password is invalid"));
			return "login";
		}
		{
			JSFUtils.setSessionAttribute("LOGIN_USER_KEY", user);
			return "welcome";
		}
	}

	public String register()
	{
		User savedUser = this.userServiceBean.save(user);
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(savedUser == null)
		{
			fc.addMessage(null, new FacesMessage("Registration failed."));
			return "register";
		}
		else
		{
			fc.addMessage(null, new FacesMessage("Registered Successfully."));
			return "login";
		}
		
	}

	public User getCurrentUser()
	{
		currentUser =JSFUtils.getCurrentUser();
		return currentUser;
	}
	public String changePwd()
	{
		String password = this.getChangePwdRequest().getPassword();
		String newPassword=this.getChangePwdRequest().getNewPassword();
		String retypePassword =this.getChangePwdRequest().getRetypePassword();
		
		String currentPwd = JSFUtils.getCurrentUser().getPassword();
		if(!newPassword.equals(retypePassword))
		{
			JSFUtils.addGlobalError("Password and Retype Password doesn't match.");
			return "changePwd";
		} else if(!password.equals(currentPwd))
		{
			JSFUtils.addGlobalError("Wrong Current Password");
			return "changePwd";
		}
		this.userServiceBean.changePassword(JSFUtils.getCurrentUser().getUserId(),newPassword);
		JSFUtils.addGlobalError("Password changed successfully");
		JSFUtils.getSession().invalidate();
		return "login.xhtml?faces-redirect=true";
	}
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public User getUser()
	{
		if(this.user==null){
			this.user = new User();
		}
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public ChangePwdRequest getChangePwdRequest()
	{
		if(this.changePwdRequest==null){
			this.changePwdRequest = new ChangePwdRequest();
		}
		return changePwdRequest;
	}

	public void setChangePwdRequest(ChangePwdRequest changePwdRequest)
	{
		this.changePwdRequest = changePwdRequest;
	}
	
	
}
