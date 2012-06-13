
package com.sivalabs.jforum.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import com.sivalabs.jforum.web.validation.ValidationGroups;

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
    @NotNull(message="UserId should not be null", 
	groups={ValidationGroups.UpdateUser.class,ValidationGroups.DeleteUser.class})
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "userName")
    @NotNull(message="UserName should not be null", 
	groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    @NotNull(message="Password should not be null", 
	groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
    private String password;
    @Basic(optional = false)
    @Column(name = "firstName")
    @NotNull(message="FirstName should not be null", 
	groups={Default.class, ValidationGroups.CreateUser.class, ValidationGroups.UpdateUser.class})
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "emailId")
    private String emailId;
    @Column(name = "active")
    private Boolean active;  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "startedBy")
    private List<Topic> topicList = new ArrayList<Topic>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedBy")
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
	public String getFullName()
	{
		return firstName+ " "+ lastName;
	}
	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
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
