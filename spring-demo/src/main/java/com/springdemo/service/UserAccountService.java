/**
 * 
 */
package com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.UserAccountDAO;
import com.springdemo.domain.UserAccount;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class UserAccountService
{
	private UserAccountDAO userAccountDAO;
	
	@Autowired
	//@Qualifier("MyBatis")
	@Qualifier("Jdbc")
	public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
		this.userAccountDAO = userAccountDAO;
	}
	
	public Integer create(UserAccount userAccount) {
		return userAccountDAO.create(userAccount);
	}

	public List<UserAccount> getAllUserAccounts() {
		return userAccountDAO.getAllUserAccounts();
	}

	
	public UserAccount getUserAccountById(int id) {
		UserAccount userAccount = null;
		try {
			userAccount = userAccountDAO.getUserAccountById(id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return userAccount;
	}

	
	public void update(UserAccount userAccount) {
		userAccountDAO.update(userAccount);
	}

	
	public void delete(UserAccount userAccount) {
		userAccountDAO.delete(userAccount);
	}

	public void delete(int id) {
		userAccountDAO.delete(new UserAccount(id));
	}
	
}
