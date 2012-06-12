/**
 * 
 */
package com.sivalabs.phonebook;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.phonebook.entities.ConfigParam;
import com.sivalabs.phonebook.entities.User;
import com.sivalabs.phonebook.services.ConfigurationService;
import com.sivalabs.phonebook.services.UserService;

/**
 * @author siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ConfigServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfigurationService configurationService;
	
	@Test
	public void testGetConfigParams() {
		List<ConfigParam> configParams = this.configurationService.getAllConfigParams();
		for (ConfigParam configParam : configParams) {
			System.err.println(configParam);
		}
	}
	
	@Test
	public void testGetUsers() {
		User user = this.userService.getUser(1);
		System.err.println(user);
	}
}
