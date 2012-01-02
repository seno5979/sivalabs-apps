/**
 * 
 */
package com.sivalabs.utilities.cache;

/**
 * @author Siva
 *
 */
public class CacheVO
{
	private String cacheId;
	private Object cachedObject;
	
	public String getCacheId()
	{
		return cacheId;
	}
	public void setCacheId(String cacheId)
	{
		this.cacheId = cacheId;
	}
	public Object getCachedObject()
	{
		return cachedObject;
	}
	public void setCachedObject(Object cachedObject)
	{
		this.cachedObject = cachedObject;
	}
	
}
