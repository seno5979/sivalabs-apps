/**
 * 
 */
package com.sivalabs.loadbalancer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class ServerFactory
{
	public static List<Server> getServers(String clusterId)
	{
		List<Server> servers = new ArrayList<Server>();
		Server hydServer = new HyderabadServer();
		Server chenServer = new ChennaiServer();
		Server blglrServer = new BangloreServer();
		
        servers.add(hydServer);
        servers.add(chenServer);
        servers.add(blglrServer);
        
        return servers;
	}
}
