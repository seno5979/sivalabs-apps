/**
 * 
 */
package com.sivalabs.loadbalancer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Siva
 *
 */
public class RoundRobinStrategy implements ServerPickStrategy
{
	
	private static final Logger logger = LoggerFactory.getLogger(RoundRobinStrategy.class);
	
	
	private List<Server> servers;
	private Map<Integer, Server> serverMap = new HashMap<Integer, Server>();
	private Integer lastUsedServerCounter = null;
	
	public RoundRobinStrategy(List<Server> servers)
	{
		this.servers = servers;
		this.init();
	}

	private void init()
	{
		Integer counter = 0;
		for (Server server : servers)
		{
			serverMap.put(counter, server);
			counter++;
		}
		logger.debug("ServerMap: {}", serverMap);
	}

	@Override
	public Server pickTheLuckyServer()
	{
		Integer serverCounter = 0;
		logger.debug("lastUsedServerCounter : {}", lastUsedServerCounter);
		if(this.lastUsedServerCounter != null && (this.lastUsedServerCounter != serverMap.size()-1))
		{
			serverCounter = this.lastUsedServerCounter + 1;
		}
		
		int count = serverMap.size();
		for (int i = 0; i < count; i++)
		{				
			Server server = serverMap.get(serverCounter);
			if(server.getStatus()==ServerStatus.READY)
			{
				this.lastUsedServerCounter = serverCounter;
				logger.debug("lastUsedServerCounter set to : {}", lastUsedServerCounter);
				return server;
			}
			else {
				if(serverCounter == count -1){
					serverCounter = 0;
				}else{
					serverCounter++;
				}
			}
		}
		throw new RuntimeException("No Server is ready to process the request.");
	}

}
