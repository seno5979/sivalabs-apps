/**
 * 
 */
package com.sivalabs.jforum.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sivalabs.jforum.entities.User;
 
/**
 * @author siva
 *
 */
public class WebUtils {
	private static final String LOGIN_USER_KEY = "LOGIN_USER";
	
	public static void setLoginUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(LOGIN_USER_KEY, user);
	}
	
	public static User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(LOGIN_USER_KEY);
	}
	
	public static void setLoginUser(HttpSession session, User user) {
		session.setAttribute(LOGIN_USER_KEY, user);
	}
	
	public static User getLoginUser(HttpSession session) {
		return (User) session.getAttribute(LOGIN_USER_KEY);
	}
	
	public static boolean isUserLoggedIn(HttpSession session) {
		return (session.getAttribute(LOGIN_USER_KEY) != null);
	}
}
