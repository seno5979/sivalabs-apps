/**
 * 
 */
package com.springdemo.domain;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author skatam
 *
 */
public class UserAccount {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	public UserAccount() {
	}
	public UserAccount(int id) {
		this.id = id;
	}
	public UserAccount(int id, String firstName, String lastName, Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
