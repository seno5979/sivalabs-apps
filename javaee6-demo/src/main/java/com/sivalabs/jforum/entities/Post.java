/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sivalabs.jforum.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author skatam
 */
@Entity
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "post_id")
    private Integer postId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "posted_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedOn;
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    @ManyToOne(optional = false)
    private Topic topic;
    @JoinColumn(name = "posted_by", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User postedBy;

    public Post() {
    }

    public Post(Integer postId) {
        this.postId = postId;
    }

    public Post(Integer postId, String title, String message, Date postedOn) {
        this.postId = postId;
        this.title = title;
        this.message = message;
        this.postedOn = postedOn;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    
    public User getPostedBy()
	{
		return postedBy;
	}

	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}

}
