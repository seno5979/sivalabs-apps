/**
 * 
 */
package com.springdemo.dao;

import java.util.List;

import com.springdemo.domain.UserAccount;

/**
 * @author skatam
 *
 */
public interface UserAccountDAO 
{
	Integer create(UserAccount userAccount);
	List<UserAccount> getAllUserAccounts();
	UserAccount getUserAccountById(int id);
	void update(UserAccount userAccount);
	void delete(UserAccount userAccount);
}
