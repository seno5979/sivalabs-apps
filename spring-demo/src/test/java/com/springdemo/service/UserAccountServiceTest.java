/**
 * 
 */
package com.springdemo.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springdemo.domain.UserAccount;
import com.springdemo.service.UserAccountService;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserAccountServiceTest
{
	@Autowired
	UserAccountService userAccountService = null;
	
	@Test
	public void createUserTest()
	{
		UserAccount userAccount = new UserAccount(0,"Guest","Guest",null);
		Integer id = userAccountService.create(userAccount);
		Assert.assertNotNull(id);
		Assert.assertTrue(id>0);
	}
	
	//@Test
	public void getAllUserAccounts() 
	{
		List<UserAccount> accounts = userAccountService.getAllUserAccounts();
		Assert.assertNotNull(accounts);
		for (UserAccount userAccount : accounts) 
		{
			System.out.println(userAccount);
		}
	}
	
	//@Test
	public void getUserAccountByIdTest() 
	{
		UserAccount userAccount = userAccountService.getUserAccountById(1);
		Assert.assertNotNull(userAccount);
		System.out.println(userAccount);
	}
	
	//@Test
	public void updateUserAccountTest() {
		UserAccount userAccount = userAccountService.getUserAccountById(1);
		userAccount.setBirthDate(new Date());
		userAccountService.update(userAccount);
	}
	
	//@Test
	public void deleteUserAccountTest() {
		userAccountService.delete(5);
		UserAccount userAccount = userAccountService.getUserAccountById(5);
		Assert.assertNull(userAccount);
	}
	
	
	
	
	public static void main(String[] args) 
	{
		ApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserAccountService userAccountService = springContext.getBean(UserAccountService.class);
		UserAccount userAccount = null;
		/*
		System.out.println("============getAllUserAccounts==============");
		List<UserAccount> accounts = userAccountService.getAllUserAccounts();
		for (UserAccount userAccount : accounts) {
			System.out.println(userAccount);
		}
		System.out.println("============getUserAccountById==============");
		userAccount = userAccountService.getUserAccountById(1);
		System.out.println(userAccount);
		*/
		
		System.out.println("============Create UserAccount==============");
		userAccount = new UserAccount(0,"Guest","Guest",null);
		Integer id = userAccountService.create(userAccount);
		/*
		System.out.println("============Update UserAccount==============");
		userAccount = userAccountService.getUserAccountById(id);
		userAccount.setBirthDate(new Date());
		userAccountService.update(userAccount);
		
		System.out.println("============Delete UserAccount==============");
		userAccountService.delete(id);
		*/
	}

}
