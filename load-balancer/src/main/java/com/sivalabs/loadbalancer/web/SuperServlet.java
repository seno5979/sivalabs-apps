package com.sivalabs.loadbalancer.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivalabs.loadbalancer.LoadBalancer;
import com.sivalabs.loadbalancer.LoadBalancerBuilder;
import com.sivalabs.loadbalancer.LoadBalancerRegistry;
import com.sivalabs.loadbalancer.Request;
import com.sivalabs.loadbalancer.Response;
import com.sivalabs.loadbalancer.Task;

/**
 * Servlet implementation class SuperServlet
 */
public class SuperServlet extends HttpServlet 
{
	private static final Logger logger = LoggerFactory.getLogger(SuperServlet.class);
	private static final long serialVersionUID = 1L;

    private LoadBalancer loadBalancer;
    
	public void init(ServletConfig config) throws ServletException 
	{
        String type = config.getInitParameter("SERVER_PICK_STRATEGY");
        logger.debug("ServerPickStrategy Type {}", type);
        loadBalancer = LoadBalancerBuilder.build("DEFAULT_CLUSTER", type);
        //getServletContext().setAttribute("DEFAULT_LB", loadBalancer);
        LoadBalancerRegistry.putLoadBalancer("DEFAULT_LB", loadBalancer);
        logger.debug("************* LoadBalancer Initialized *************");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		final String taskName = request.getParameter("task");
		Request req = new Request();
        Task task = new Task() 
        {
            @Override
            public Object execute() 
            {
                System.err.println("Executing ["+taskName+"] at :"+new Date());
                return "Success";
            }
        };
        req.setTask(task);
        Response resp = loadBalancer.process(req);
        Object result = resp.getResult();
        request.getSession().setAttribute("RESULT", result);
        response.sendRedirect("index.jsp");
        //response.getWriter().println(result);
	}

	@Override
	public void destroy()
	{
		super.destroy();
		loadBalancer.shutdown();
	}

}
