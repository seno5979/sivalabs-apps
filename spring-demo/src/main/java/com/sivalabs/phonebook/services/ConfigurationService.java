/**
 * 
 */
package com.sivalabs.phonebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.phonebook.dao.ConfigurationDAO;
import com.sivalabs.phonebook.entities.ConfigParam;

/**
 * @author siva
 *
 */
@Service
@Transactional("mybatisTxnMgr")
public class ConfigurationService 
{
	@Autowired	
	private ConfigurationDAO configurationDAO;

	public Integer create(ConfigParam ConfigParam) {
		return configurationDAO.create(ConfigParam);
	}

	
	public List<ConfigParam> getAllConfigParams() {
		return configurationDAO.getAllConfigParams();
	}

	
	public ConfigParam getConfigParamById(int id) {
		return (ConfigParam) configurationDAO.getConfigParamById(id);
	}

	
	public void update(ConfigParam ConfigParam) {
		configurationDAO.update(ConfigParam);
	}

	
	public void delete(ConfigParam ConfigParam) {
		configurationDAO.delete(ConfigParam);
	}
}
