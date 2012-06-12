/**
 * 
 */
package com.sivalabs.cdidemo.interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siva
 *
 */
@Interceptor
@Log
public class LogInterceptor implements Serializable 
{
    private static final long serialVersionUID = 8139854519874743530L;
    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    
    @AroundInvoke
    public Object logMethodEntry(InvocationContext ctx) throws Exception {
        logger.info("Before entering method:" + ctx.getMethod().getName());
        return ctx.proceed();
    }
}