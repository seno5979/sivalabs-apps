/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sivalabs.loadbalancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author skatam
 */
public class LoadBalancer
{
	private static final Logger logger = LoggerFactory.getLogger(LoadBalancer.class);
	
    private Cluster cluster;
    private ServerPickStrategy serverPickStrategy;
    
    public static LoadBalancer build(Cluster cluster, ServerPickStrategy strategy) {
        if(cluster==null){
            throw new IllegalArgumentException("Cluster is null");
        }
        if(strategy == null){
        	throw new IllegalArgumentException("ServerPickStrategy is null");
        }
        return new LoadBalancer(cluster, strategy);
    }

    private LoadBalancer(Cluster cluster, ServerPickStrategy strategy)
    {
        this.cluster = cluster;
        this.serverPickStrategy = strategy;
        this.init();
    }

    private void init()
	{
    	logger.debug("****** Initializing LoadBalancer *********");
    	cluster.init();
    	logger.debug("Completed.");
	}

	public void shutdown()
	{
		cluster.shutdown();
	}
	

	public Response process(Request request)
    {
        Server srvr = serverPickStrategy.pickTheLuckyServer();
        logger.debug("Server Picked : {}", srvr);
        return srvr.process(request);
    }

	public void changeServerStatus(String serverId, ServerStatus status)
	{
		Server server = cluster.getServerById(serverId);
		if(server != null && status != null)
		{
			server.updateStatus(status);
		}
	}
}
