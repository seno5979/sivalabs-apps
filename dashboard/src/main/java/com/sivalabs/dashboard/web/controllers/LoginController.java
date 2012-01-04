/**
 * 
 */
package com.sivalabs.dashboard.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sivalabs.dashboard.bo.UserServiceEJBLocal;
import com.sivalabs.dashboard.model.User;
import com.sivalabs.dashboard.utils.JNDIUtils;

/**
 * @author siva
 *
 */
@Controller
public class LoginController
{
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model)
	{
		model.addAttribute("login", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView doLogin(User user, HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView();
		String view = "login";
		UserServiceEJBLocal userServiceEJB = (UserServiceEJBLocal) JNDIUtils.lookup("sivalabs/UserServiceEJB/local");
		User loggedinUser = userServiceEJB.login(user.getUsername(), user.getPassword());
		if(loggedinUser!= null){
			view="welcome";
			request.getSession().setAttribute("LOGIN_USER", loggedinUser);
		}else{
			request.setAttribute("ERROR_MSG", "Invalid UserName and Password.");
		}
		mav.setViewName(view);
		return mav;
	}
}
