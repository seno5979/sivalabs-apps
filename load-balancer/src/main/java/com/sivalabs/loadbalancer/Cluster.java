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
public class Cluster
{
	private static final Logger logger = LoggerFactory.getLogger(Cluster.class);
	
	private List<Server> servers;

	public Cluster(List<Server> servers)
	{
		if(servers == null || servers.isEmpty()){
			throw new IllegalArgumentException("Servers is null or empty.");
		}
		this.servers = servers;
	}

	public List<Server> getServers()
	{
		return servers;
	}

	public void setServers(List<Server> servers)
	{
		this.servers = servers;
	}
	
	void init()
	{
    	logger.debug("****** Initializing Cluster *********");
    	for (Server server : servers)
		{
			server.start();
		}
    	logger.debug("Completed.");
	}
	
	public void shutdown()
	{
		for (Server server : servers)
		{
			server.stop();
		}
	}

	public Server getServerById(String serverId)
	{
		for (Server server : servers)
		{
			if(server.getId().equals(serverId)){
				return server;
			}
		}
		return null;
	}
	
}
