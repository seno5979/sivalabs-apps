/**
 * 
 */
package com.sivalabs.linkshare;

import javax.inject.Named;

/**
 * @author Siva
 *
 */
@Named
public class LinkShareController
{
	private String author = "Siva";
	
	public String getAuthor()
	{
		return author;
	}
	public String home()
	{
		return "home";
	}
}
