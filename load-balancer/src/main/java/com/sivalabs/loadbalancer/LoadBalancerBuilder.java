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
public class LoadBalancerBuilder
{
	private static final Logger logger = LoggerFactory.getLogger(LoadBalancerBuilder.class);
	
	
	public static LoadBalancer build(String clusterId, String serverPickStrategyType)
	{
		List<Server> servers = ServerFactory.getServers(clusterId);
		Cluster cluster = new Cluster(servers);
		
        ServerPickStrategyType type = ServerPickStrategyType.valueOf(serverPickStrategyType);
		ServerPickStrategy strategy = ServerPickStrategyFactory.getServerPickStrategy(servers, type );
		logger.debug("ServerPickStrategy :"+strategy);
		
        return LoadBalancer.build(cluster, strategy);
        
	}
}
