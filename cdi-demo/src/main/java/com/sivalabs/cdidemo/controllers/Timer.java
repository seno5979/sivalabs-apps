/**
 * 
 */
package com.sivalabs.cdidemo.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * @author Siva
 *
 */
@RequestScoped
public class Timer
{
	private long start;
	private long end;
	
	@com.sivalabs.cdidemo.controllers.Logger
    @Inject
    private Logger logger = null;
    
	public Timer()
	{
		System.out.println("---------Timer()-------------");
	}
	@PostConstruct
	void init()
	{
		System.out.println("---------Timer.init()-------------");
		start = end = System.currentTimeMillis();
	}
	
	public void start()
	{
		start = System.currentTimeMillis();
		logger.debug("start :"+start);
	}
	
	public void end()
	{
		end = System.currentTimeMillis();
		logger.debug("end :"+end);
	}
	
	public long getTime()
	{
		logger.debug("time diff :"+(end - start));
		return end - start;
	}
}
