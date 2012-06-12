/**
 * 
 */
package com.sivalabs.jforum.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Siva
 *
 */
@Entity
public class ForumUser extends User
{
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "startedBy")
    private List<Topic> topicList = new ArrayList<Topic>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postedBy")
    private List<Post> postList = new ArrayList<Post>();
    private int totalTopics;
    private int totalPosts;
    
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

	public int getTotalTopics()
	{
		return totalTopics;
	}

	public void setTotalTopics(int totalTopics)
	{
		this.totalTopics = totalTopics;
	}

	public int getTotalPosts()
	{
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts)
	{
		this.totalPosts = totalPosts;
	}
	
}
