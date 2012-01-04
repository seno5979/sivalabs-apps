/**
 * 
 */
package com.sivalabs.dashboard.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author siva
 *
 */
public class JNDIUtils
{
	public static Object lookup(String jndiName)
	{
		Object object = null;
		try
		{
			Context context = new InitialContext();
			object = context.lookup(jndiName);
		} 
		catch (NamingException e)
		{
			e.printStackTrace();
		}
		return object;
	}
}
