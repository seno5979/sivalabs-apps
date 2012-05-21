package com.sivalabs.jforum.utils;

import org.slf4j.LoggerFactory;

/**
 * Logger Wrapper to hide the actual Logger used to facilitate switching Logger Implementations.
 *
 */
public class Logger 
{
    private org.slf4j.Logger actualLogger;
    
    private Logger(org.slf4j.Logger actualLogger) {
    	this.actualLogger = actualLogger;
    }
	public static Logger getLogger(Class<?> clazz) {
		return new Logger(LoggerFactory.getLogger(clazz));
	}

	public void error(String msg) {
		this.actualLogger.error(msg);
	}
	public void error(Throwable throwable) {
		this.actualLogger.error(null,throwable);
	}
	public void error(String msg, Throwable throwable) {
		this.actualLogger.error(msg, throwable);
	}

	public void warn(String msg) {
		this.actualLogger.warn(msg);
	}

	public void info(String msg) {
		this.actualLogger.info(msg);
	}

	public void debug(String msg) {
		this.actualLogger.debug(msg);
	}
	
}
