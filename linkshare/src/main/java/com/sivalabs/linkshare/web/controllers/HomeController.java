/**
 * 
 */
package com.sivalabs.linkshare.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivalabs.linkshare.UserNotLoggedinException;
import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.services.LinkShareService;

/**
 * @author skatam
 *
 */
@Controller
public class HomeController 
{
	@Autowired
	private LinkShareService linkShareService;
	
	@RequestMapping("welcome")
	public String welcome() 
	{
		return "welcome";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) 
	{
		session.invalidate();
		return "redirect:welcome.htm";
	}
	
	@RequestMapping(value="home")
	public String home(Model model, HttpSession session) 
	{
		List<Link> allLinks = this.linkShareService.findAllLinks();
		model.addAttribute("ALL_LINKS", allLinks);
		return "home";
	}

	@ExceptionHandler(UserNotLoggedinException.class)
	public String redirectToLogin() {
		return "redirect:login.htm";
	}
}
