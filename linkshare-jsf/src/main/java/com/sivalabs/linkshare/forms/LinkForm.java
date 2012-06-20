/**
 * 
 */
package com.sivalabs.linkshare.forms;

import java.io.Serializable;

/**
 * @author Siva
 *
 */
public class LinkForm implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer linkId;
	private String title;
	private String url;
	private String description;
	
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


}
