/**
 * 
 */
package com.springdemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author skatam
 *
 */
@Component
@Aspect
public class PerformanceMonitoringAspect 
{
	@Around("execution(* com.springdemo.service.UserAccountService.*(..))")
	public Object monitor(ProceedingJoinPoint joinPoint)
	{
		Object result = null;
		long start = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.err.println("Time taken :"+(end-start)+" milliseconds");
		return result;
	}
}
