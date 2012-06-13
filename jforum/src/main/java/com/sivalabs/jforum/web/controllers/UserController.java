/**
 * 
 */
package com.sivalabs.jforum.web.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.services.UserService;
import com.sivalabs.jforum.web.forms.ChangePwd;


/** 
 * @author siva
 *
 */
@Controller
public class UserController 
{
	@Inject
	private UserService userService;

	@RequestMapping(value="/home")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, HttpServletRequest request, BindingResult result) {
		User loginUser = this.userService.login(user.getUserName(), user.getPassword());
		if(loginUser!=null){
			request.getSession().setAttribute("LOGIN_USER", loginUser);
			return "redirect:home";
		}else{
			result.addError(new ObjectError("user", "Invalid UserName & Password."));
			return "login";
		}
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		if(result.hasErrors()){
			return "registration";
		}
		User savedUser = this.userService.saveUser(user);
		if(savedUser!=null){
			redirectAttributes.addFlashAttribute("MSG", "Registered Successfully"); 		
			return "redirect:login";
		}else{
			redirectAttributes.addFlashAttribute("MSG", "Registration Failed.");
			return "registration";
		}
	}
	
	@RequestMapping(value="/showUser", method=RequestMethod.GET)
	public String showUserAccount(Model model, HttpServletRequest request) {
		User loginUser = (User) request.getSession().getAttribute("LOGIN_USER");;
		model.addAttribute("user",loginUser);
		return "user";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		if(result.hasErrors()){
			return "user";
		}
		User savedUser = this.userService.saveUser(user);
		if(savedUser!=null){
			WebUtils.setLoginUser(request, this.userService.getUser(user.getUserId()));
			redirectAttributes.addFlashAttribute("MSG", "User Updated Successfully"); 		
			return "redirect:home";
		}else{
			redirectAttributes.addFlashAttribute("MSG", "User Updation Failed.");
			return "user";
		}
	}
	
	@RequestMapping(value="/changePwd", method=RequestMethod.GET)
	public String changePwdForm(Model model, HttpServletRequest request) {
		model.addAttribute("changePwd", new ChangePwd());
		return "changePwd";
	}
	
	
	@RequestMapping(value="/changePwd", method=RequestMethod.POST)
	public String changePwd(@Valid @ModelAttribute("changePwd") ChangePwd changePwd, BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		
		if(result.hasErrors()){
			return "changePwd";
		}
		if(!changePwd.getNewPwd().equals(changePwd.getRetypePwd())){
			result.addError(new ObjectError("retypePwd", "New Password and Retype Password doesn't match"));
		}
		if(result.hasErrors()){
			return "changePwd";
		}
		User loginUser = WebUtils.getLoginUser(request);
		if(!changePwd.getPwd().equals(loginUser.getPassword())){
			result.addError(new ObjectError("retypePassword", "Current Password doesn't match"));
		}
		if(result.hasErrors()){
			return "changePwd";
		}
		boolean success = this.userService.changePwd(loginUser.getUserId(), changePwd.getPwd(), changePwd.getNewPwd());
		if(success){
			WebUtils.setLoginUser(request, this.userService.getUser(loginUser.getUserId()));
			redirectAttributes.addFlashAttribute("MSG", "Password Updated Successfully"); 		
			return "redirect:home";
		}else{
			redirectAttributes.addFlashAttribute("MSG", "Password Updation Failed.");
			return "changePwd";
		}
	}
	
	
}
