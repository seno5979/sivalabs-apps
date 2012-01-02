package com.sivalabs.grailsapp.controllers

class LoginController {

    def index = {
		render(view : "/login");
	}
	
	def login = { LoginCommand cmd ->
		if(cmd.hasErrors()){
			render(view:"/login", model :[user : cmd])
		} 
		else if("admin".equals(cmd.username) && "admin".equals(cmd.password))
		{
			log.error("success....");
			session.user = cmd;
			redirect(controller:"home", action:"");
		}
		else {
			log.error("failure....");
			render(view:"/login", model :[user : cmd])
		}
	}
}

class LoginCommand{
	String username
	String password
	
	static constraints = {
		username(blank : false)
		password(blank:false)
	}
}
