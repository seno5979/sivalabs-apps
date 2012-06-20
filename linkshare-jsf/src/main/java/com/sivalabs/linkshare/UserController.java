/**
 * 
 */
package com.sivalabs.linkshare;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.forms.ChangePwdForm;
import com.sivalabs.linkshare.services.LinkShareService;
import com.sivalabs.linkshare.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@ManagedBean
@ViewScoped
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EJB
	private LinkShareService linkShareService;
	
	private String userName = "admin";
	private String password = "admin";
	
	private User user;
	private User currentUser;
	private ChangePwdForm changePwdForm;
	
	public String login()
	{
		User user = this.linkShareService.login(userName, password);
		if(user == null)
		{
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage(null, new FacesMessage("UserName or Password is invalid"));
			return "login";
		}
		{
			currentUser = user;
			JSFUtils.setCurrentUser(user);
			return "home.jsf?faces-redirect=true";
			//return "home";
		}
	}
	public String logout()
	{
		JSFUtils.logout();
		return "index.jsf?faces-redirect=true";
	}
	public String register()
	{
		User savedUser = this.linkShareService.save(user);
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
		String password = this.getChangePwdForm().getPassword();
		String newPassword=this.getChangePwdForm().getNewPassword();
		String retypePassword =this.getChangePwdForm().getRetypePassword();
		
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
		this.linkShareService.changePassword(JSFUtils.getCurrentUser().getUserId(),newPassword);
		JSFUtils.addGlobalError("Password changed successfully");
		JSFUtils.logout();
		return "login.jsf?faces-redirect=true";
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

	public ChangePwdForm getChangePwdForm()
	{
		if(this.changePwdForm==null){
			this.changePwdForm = new ChangePwdForm();
		}
		return changePwdForm;
	}

	public void setChangePwdForm(ChangePwdForm changePwdForm)
	{
		this.changePwdForm = changePwdForm;
	}
	
	
}
