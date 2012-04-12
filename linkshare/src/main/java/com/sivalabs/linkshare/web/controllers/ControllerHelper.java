/**
 * 
 */
package com.sivalabs.linkshare.web.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivalabs.linkshare.UserNotLoggedinException;
import com.sivalabs.linkshare.entities.User;

/**
 * @author skatam
 *
 */
public class ControllerHelper {
	private static final Logger logger = LoggerFactory.getLogger(ControllerHelper.class);
	private static final String LOGIN_USER_KEY = "LOGIN_USER";
	
	
	public static User getLoggedInUser(HttpSession session) {
		User loginUser = (User) session.getAttribute(LOGIN_USER_KEY);
		logger.debug("loginUser :"+loginUser);
		if(loginUser == null)
		{
			throw new UserNotLoggedinException();
		}
		return loginUser;
	}
	
	public static void setLoggedInUser(HttpSession session, User user) {
		session.setAttribute(LOGIN_USER_KEY, user);
	}
	
	public static boolean isUserLoggedIn(HttpSession session) {
		return (session.getAttribute(LOGIN_USER_KEY) != null);
	}
}
