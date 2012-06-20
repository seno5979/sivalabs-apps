package com.sivalabs.linkshare.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Link implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer linkId;
	private String title;
	private String url;
	private String description;
	private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getLinkId()
	{
		return linkId;
	}

	public void setLinkId(Integer linkId)
	{
		this.linkId = linkId;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	@ManyToOne
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

}