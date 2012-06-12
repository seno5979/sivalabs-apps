/**
 * 
 */
package com.sivalabs.phonebook.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sivalabs.phonebook.entities.ConfigParam;


/**
 * @author siva
 *
 */
@Repository
public class ConfigurationDAOImpl extends SqlSessionDaoSupport implements ConfigurationDAO
{
	
	private ConfigurationDAO getConfigParamMapper(){
		return this.getSqlSession().getMapper(ConfigurationDAO.class);
	}
	
	@Override
	public Integer create(ConfigParam ConfigParam) {
		return getConfigParamMapper().create(ConfigParam);
	}

	@Override
	public List<ConfigParam> getAllConfigParams() {
		return getConfigParamMapper().getAllConfigParams();
	}

	@Override
	public ConfigParam getConfigParamById(int id) {
		return (ConfigParam) getConfigParamMapper().getConfigParamById(id);
	}

	@Override
	public void update(ConfigParam ConfigParam) {
		getConfigParamMapper().update(ConfigParam);
	}

	@Override
	public void delete(ConfigParam ConfigParam) {
		getConfigParamMapper().delete(ConfigParam);
	}


}
