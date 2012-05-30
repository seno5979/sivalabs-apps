/**
 * 
 */
package com.sivalabs.cdidemo.controllers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siva
 *
 */
public class LogHandler
{

	@Produces @com.sivalabs.cdidemo.controllers.Logger
	public Logger getLogger(InjectionPoint injectionPoint)
	{
		System.out.println("----------LogHandler.getHandler()--------");
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
	}
	
	public void closeLogHandler(@Disposes Logger logger)
	{
		System.out.println("Closing Logger.....");		
	}
}
