/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sivalabs.jforum.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author skatam
 */
@Entity
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "topic_id")
    private Integer topicId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "posted_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;
    @JoinColumn(name = "forum_id", referencedColumnName = "forum_id")
    @ManyToOne(optional = false)
    private Forum forum;
    @JoinColumn(name = "started_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User startedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    private List<Post> postList = new ArrayList<Post>();

    public Topic() {
    }

    public Topic(Integer topicId) {
        this.topicId = topicId;
    }

    public Topic(Integer topicId, String title, Date postedOn) {
        this.topicId = topicId;
        this.title = title;
        this.postedOn = postedOn;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

   

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

   

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

	public User getStartedBy()
	{
		return startedBy;
	}

	public void setStartedBy(User startedBy)
	{
		this.startedBy = startedBy;
	}

}
