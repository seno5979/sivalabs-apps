/**
 * 
 */
package com.sivalabs.linkshare.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.repositories.LinkRepository;
import com.sivalabs.linkshare.repositories.UserRepository;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class LinkShareService 
{
	@Autowired private UserRepository userRepository;
	@Autowired private LinkRepository linkRepository;

	public Integer saveUser(User user) 
	{
		return userRepository.save(user).getUserId();
	}

	public List<User> findAllUsers() 
	{
		return userRepository.findAll();
	}
	public User findUser(Integer userId) 
	{
		return userRepository.findOne(userId);
	}
	public User login(String userName, String password)
	{
		return this.userRepository.login(userName, password);
	}
	
	
	public List<Link> findAllLinks()
	{
		return this.linkRepository.findAll(new Sort(Direction.DESC, "postedOn"));
	}
	
	public Integer saveLink(Link link) {
		return this.linkRepository.save(link).getLinkId();
	}
	
	public void saveLinks(Link... links) {
		if(links!=null && links.length>0){
			this.linkRepository.save(Arrays.asList(links));
		}
	}
	
	public void saveUserLinks(Integer userId, Link... links) {
		User user = this.userRepository.findOne(userId);
		if(links !=null)
		{
			for (Link link : links) 
			{
				link.setPostedBy(user);
				user.getLinks().add(link);
			}
		}
	}

	public List<Link> findUserLinks(Integer userId) {
		return new ArrayList<Link>(this.findUser(userId).getLinks());
	}
}
