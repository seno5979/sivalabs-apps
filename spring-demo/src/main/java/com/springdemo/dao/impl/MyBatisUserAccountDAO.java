/**
 * 
 */
package com.springdemo.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.UserAccountDAO;
import com.springdemo.domain.UserAccount;

/**
 * @author skatam
 *
 */
@Repository
@Qualifier("MyBatis")
public class MyBatisUserAccountDAO extends SqlSessionDaoSupport implements UserAccountDAO
{
	
	private UserAccountDAO getUserAccountMapper(){
		return this.getSqlSession().getMapper(UserAccountDAO.class);
	}
	
	@Override
	public Integer create(UserAccount userAccount) {
		return getUserAccountMapper().create(userAccount);
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return getUserAccountMapper().getAllUserAccounts();
	}

	@Override
	public UserAccount getUserAccountById(int id) {
		return (UserAccount) getUserAccountMapper().getUserAccountById(id);
	}

	@Override
	public void update(UserAccount userAccount) {
		getUserAccountMapper().update(userAccount);
	}

	@Override
	public void delete(UserAccount userAccount) {
		getUserAccountMapper().delete(userAccount);
	}

}
