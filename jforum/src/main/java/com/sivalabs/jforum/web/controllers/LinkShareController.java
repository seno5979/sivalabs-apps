package com.sivalabs.jforum.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.jforum.entities.Link;
import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.services.LinkShareService;


/**
 * @author skatam
 *
 */
@Controller
public class LinkShareController extends BaseController
{
	
	@Autowired
	private LinkShareService linkShareService;
	
	@RequestMapping(value="postLink", method=RequestMethod.GET)
	public String newLinkForm(Model model) 
	{
		model.addAttribute("newLink", new Link());
		return "postLink";
	}
	
	@RequestMapping(value="postLink", method=RequestMethod.POST)
	public String submitNewLink(@Validated @ModelAttribute Link link, 
								BindingResult result, 
								Model model, 
								HttpSession session,
								RedirectAttributes redirectAttributes) 
	{
		String url = link.getUrl();
		if(!url.startsWith("http://")){
			url = "http://"+url;
		}
		link.setUrl(url);
		User loginUser = WebUtils.getLoginUser(session);
		link.setPostedBy(loginUser);
		link.setPostedOn(new Date());
		this.linkShareService.saveLink(link);
		logger.debug("Link posted successfully.");
		redirectAttributes.addFlashAttribute("message", "Link posted successfully.");
		return "redirect:/home";
	}
}
