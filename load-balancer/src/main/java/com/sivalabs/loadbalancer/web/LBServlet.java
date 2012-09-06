/**
 * 
 */
package com.sivalabs.loadbalancer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivalabs.loadbalancer.LoadBalancer;
import com.sivalabs.loadbalancer.LoadBalancerRegistry;
import com.sivalabs.loadbalancer.ServerStatus;

/**
 * @author Siva
 *
 */
public final class LBServlet extends HttpServlet 
{

	private static final Logger logger = LoggerFactory.getLogger(LBServlet.class);
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		final String serverId = request.getParameter("serverId");
		final String serverStatus = request.getParameter("serverStatus");
		logger.info("serverId :{}, serverStatus:{}",serverId, serverStatus);
		LoadBalancer loadBalancer = LoadBalancerRegistry.getLoadBalancer("DEFAULT_LB");
		loadBalancer.changeServerStatus(serverId, ServerStatus.valueOf(serverStatus));
        request.getSession().setAttribute("LB_ACTION_RESULT", "SUCCESS");
        response.sendRedirect("index.jsp");
	}

}
