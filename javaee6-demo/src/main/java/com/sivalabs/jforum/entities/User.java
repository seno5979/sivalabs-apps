/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sivalabs.jforum.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author skatam
 */
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private Boolean active;  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startedBy", fetch=FetchType.LAZY)
    private List<Topic> topicList = new ArrayList<Topic>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedBy", fetch=FetchType.LAZY)
    private List<Post> postList = new ArrayList<Post>();

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}

	public List<Topic> getTopicList()
	{
		return topicList;
	}

	public void setTopicList(List<Topic> topicList)
	{
		this.topicList = topicList;
	}

	public List<Post> getPostList()
	{
		return postList;
	}

	public void setPostList(List<Post> postList)
	{
		this.postList = postList;
	}

}
