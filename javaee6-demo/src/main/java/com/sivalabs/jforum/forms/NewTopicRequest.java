/**
 * 
 */
package com.sivalabs.jforum.forms;

import java.io.Serializable;

/**
 * @author Siva
 *
 */
public class NewTopicRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int forumId;
	private String title;
	private String message;
	public int getForumId()
	{
		return forumId;
	}
	public void setForumId(int forumId)
	{
		this.forumId = forumId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
}
