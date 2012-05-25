/**
 * 
 */
package com.sivalabs.jforum.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sivalabs.jforum.entities.User;

/**
 * @author Siva
 *
 */
public class JSFUtils
{
	public static HttpSession getSession()
	{
		return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	public static void setSessionAttribute(String key , Object value)
	{
		getSession().setAttribute(key, value);
	}
	
	public static Object getSessionAttribute(String key)
	{
		return getSession().getAttribute(key);
	}
	
	public static User getCurrentUser()
	{
		User loginUser = JSFUtils.getSessionAttribute("LOGIN_USER_KEY", User.class);
		return loginUser;
	}
	
	@SuppressWarnings("unchecked")
	public static <T>  T getSessionAttribute(String key, Class<T> clazz)
	{
		return (T)getSession().getAttribute(key);
	}

	public static void addGlobalError(String msg)
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
}
