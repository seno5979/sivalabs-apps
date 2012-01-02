package com.sivalabs.grailsapp.controllers

import com.sivalabs.grailsapp.model.User;

class RegistrationController {

    def index = { 
		def userInstance = new User()
        userInstance.properties = params
		render(view:"/register", model: [user: userInstance]);
	}
	
	def register = {
		
		def user = new User(params);
		if(user.save(flush:true))
		{
			flash.message = "User Registered Successfully";
			redirect(controller:"login", action:"")
		}
		else
		{
			render(view: "/register", model: [user: user])
		}
    }
	
	def login = {
		redirect(controller:'login', action:"");
	}
}


