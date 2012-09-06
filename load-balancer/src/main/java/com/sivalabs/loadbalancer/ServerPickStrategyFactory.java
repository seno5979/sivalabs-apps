/**
 * 
 */
package com.sivalabs.loadbalancer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Siva
 *
 */
public class ServerPickStrategyFactory
{
	private static final Logger logger = LoggerFactory.getLogger(ServerPickStrategyFactory.class);
	
	public static ServerPickStrategy getServerPickStrategy(List<Server> servers, ServerPickStrategyType type)
	{
		if(type == ServerPickStrategyType.ROUND_ROBBIN){
			return new RoundRobinStrategy(servers);
		}
		logger.debug("Using Default RoundRobinStrategy.");
		return new RoundRobinStrategy(servers);		
	}
}
