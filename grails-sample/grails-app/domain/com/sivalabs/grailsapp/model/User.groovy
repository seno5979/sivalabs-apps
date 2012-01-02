package com.sivalabs.grailsapp.model;

import java.util.Date;

class User {

    String username;
	String password;
	String email;
	String phone;
	Date dob;
	
	static constraints = {
		username(blank : false)
		password(blank : false)
		email(blank : false, email: true)
		phone()
		dob(blank : false)
	}
}
