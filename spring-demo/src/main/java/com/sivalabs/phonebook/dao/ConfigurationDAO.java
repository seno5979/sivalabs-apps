/**
 * 
 */
package com.sivalabs.phonebook.dao;

import java.util.List;

import com.sivalabs.phonebook.entities.ConfigParam;

/**
 * @author siva
 *
 */
public interface ConfigurationDAO {

	Integer create(ConfigParam configParam);
	List<ConfigParam> getAllConfigParams();
	ConfigParam getConfigParamById(int id);
	void update(ConfigParam configParam);
	void delete(ConfigParam configParam);
}
