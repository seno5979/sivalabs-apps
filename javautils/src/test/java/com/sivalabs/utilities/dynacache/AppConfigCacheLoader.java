/**
 * 
 */
package com.sivalabs.utilities.dynacache;


/**
 * @author Siva
 *
 */
public class AppConfigCacheLoader implements CacheLoader
{

	@Override
	public Object loadCache()
	{
		System.out.println("Loading AppConfiguration....");
		AppConfiguration appConfiguration = new AppConfiguration();
		appConfiguration.putConfigParameter("author", "siva");
		appConfiguration.putConfigParameter("appName", "SCache");
		
		return appConfiguration;
	}

}
