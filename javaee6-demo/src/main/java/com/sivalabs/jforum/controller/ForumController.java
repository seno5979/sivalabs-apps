package com.sivalabs.jforum.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sivalabs.jforum.entities.Forum;
import com.sivalabs.jforum.entities.Post;
import com.sivalabs.jforum.entities.Topic;
import com.sivalabs.jforum.forms.NewTopicRequest;
import com.sivalabs.jforum.services.ForumServiceBean;
import com.sivalabs.jforum.services.TopicServiceBean;
import com.sivalabs.jforum.utils.JSFUtils;

@ManagedBean
@SessionScoped
public class ForumController
{
	@EJB
	private ForumServiceBean forumServiceBean;
	@EJB
	private TopicServiceBean topicServiceBean;
	
	private Forum currentForum;
	private Topic currentTopic;
	private NewTopicRequest newTopicRequest;
	
	List<Topic> topicList = null;
	List<Forum> forums = null;
	
	public List<Forum> getForums()
	{
		if(forums==null)
		{
			forums = forumServiceBean.findAll();
		}
		return forums;
	}
	
	public String showForum(Integer forumId)
	{
		this.setCurrentForum(this.forumServiceBean.findByID(forumId));
		this.topicList = null;
		return "forum";
	}
	public List<Topic> getTopics()
	{
		System.out.println("current forum id :"+getCurrentForum().getForumId());
		 if(topicList ==null)
		 {
			 topicList = this.forumServiceBean.findByID(getCurrentForum().getForumId()).getTopicList();
			//topicList = this.topicServiceBean.getTopics(getCurrentForum().getForumId());
		 }
		 return topicList;
	}
	
	public String saveNewTopic()
	{
		String view = "topic";
		try
		{
			Post post = new Post();
			post.setMessage(this.getNewTopicRequest().getMessage());
			post.setPostedBy(JSFUtils.getCurrentUser());
			post.setPostedOn(new Date());
			post.setTitle(this.getNewTopicRequest().getTitle());
			
			Topic topic = new Topic();
			topic.setForum(getCurrentForum());
			topic.setPostedOn(new Date());
			topic.setStartedBy(JSFUtils.getCurrentUser());
			topic.setTitle(this.getNewTopicRequest().getTitle());
			topic.getPostList().add(post);
			
			post.setTopic(topic);
			
			this.topicServiceBean.save(topic);
			
			this.topicList = null;//to force loading in next page
			view = "forum";
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return view;
	}

	public Forum getCurrentForum()
	{
		return currentForum;
	}

	public void setCurrentForum(Forum currentForum)
	{
		this.currentForum = currentForum;
	}

	public Topic getCurrentTopic()
	{
		return currentTopic;
	}

	public void setCurrentTopic(Topic currentTopic)
	{
		this.currentTopic = currentTopic;
	}

	public NewTopicRequest getNewTopicRequest()
	{
		if(this.newTopicRequest==null){
			this.newTopicRequest = new NewTopicRequest();
		}
		return newTopicRequest;
	}

	public void setNewTopicRequest(NewTopicRequest newTopicRequest)
	{
		this.newTopicRequest = newTopicRequest;
	}
	
	
}
