/**
 * 
 */
package com.sivalabs.linkshare.web.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.services.LinkShareService;

/**
 * @author skatam
 *
 */
@Controller
public class UserProfileController 
{
	private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);
	
	@Autowired
	private LinkShareService linkShareService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
		    ServletRequestDataBinder binder) throws Exception 
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
	    CustomDateEditor editor = new CustomDateEditor(df, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	
	@RequestMapping("secure/showUsers")
	public String showUsers(Model model) 
	{
		List<User> users = this.linkShareService.findAllUsers();
		model.addAttribute("USERS_KEY", users);
		return "showUsers";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) 
	{
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registerUser(@Validated(User.RegistrationValidation.class) @ModelAttribute User user,
								BindingResult result, 
								Model model) 
	{
		if(result.hasErrors())
		{
			return "registration";
		}
		Integer userId = this.linkShareService.saveUser(user);
		logger.debug("New UserId : "+userId);
		return "redirect:login.htm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String showLoginForm(Model model) 
	{
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@Validated(User.LoginValidation.class) @ModelAttribute User user, 
								BindingResult result, 
								Model model, 
								HttpSession session) 
	{
		if(result.hasErrors())
		{
			return "login";
		}
		
		User loginUser = this.linkShareService.login(user.getUserName(), user.getPassword());
		if(loginUser !=null)
		{
			ControllerHelper.setLoggedInUser(session, loginUser);
			return "redirect:home.htm";
		}
		else
		{
			result.reject("login.failed", "Login Failed. Please try again");
			return "login";
		}
	}
	
	@RequestMapping(value="showUserProfile")
	public String showUserProfile(Model model, HttpSession session) 
	{
		User loggedInUser = ControllerHelper.getLoggedInUser(session);
		model.addAttribute("userProfile", loggedInUser);
		List<Link> userLinks = this.linkShareService.findUserLinks(loggedInUser.getUserId());
		model.addAttribute("USER_LINKS", userLinks);
		
		return "userProfile";
	}
}
