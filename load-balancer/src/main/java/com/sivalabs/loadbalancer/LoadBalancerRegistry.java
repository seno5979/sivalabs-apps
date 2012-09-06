/**
 * 
 */
package com.sivalabs.loadbalancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siva
 *
 */
public class LoadBalancerRegistry
{
	private static final Map<String, LoadBalancer> LB_MAP = new HashMap<String, LoadBalancer>();
	
	public static void putLoadBalancer(String lbKey, LoadBalancer loadBalancer)
	{
		LB_MAP.put(lbKey,loadBalancer);
	}
	public static LoadBalancer getLoadBalancer(String lbKey)
	{
		return LB_MAP.get(lbKey);
	}
	
	
}
