/**
 * 
 */
package com.sivalabs.utilities.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Siva
 *
 */
public class CacheManager
{
	private static final CacheManager CACHE_MANAGER = new CacheManager();
	private static final Map<String, CacheVO> CACHE_MAP = new HashMap<String, CacheVO>();
	
	private CacheManager()
	{
		initCache();
	}
	
	public static final CacheManager getCacheManager()
	{
		return CACHE_MANAGER;
	}
	
	public static CacheVO getCache(String cacheId)
	{
		return CACHE_MAP.get(cacheId);
	}
	
	private void initCache()
	{
		List<CacheConfigVO> cacheConfigVOs = this.loadCacheConfiguration();
		this.loadCaches(cacheConfigVOs);
	}

	private void loadCaches(List<CacheConfigVO> cacheConfigVOs)
	{
		for (CacheConfigVO cacheConfigVO : cacheConfigVOs)
		{
			CacheVO cacheVO = this.loadCache(cacheConfigVO);
			CACHE_MAP.put(cacheVO.getCacheId(), cacheVO);
		}
	}

	private CacheVO loadCache(CacheConfigVO cacheConfigVO)
	{
		CacheVO cacheVO = new CacheVO();
		cacheVO.setCacheId(cacheConfigVO.getCacheId());
		String cacheLoaderClassName = cacheConfigVO.getCacheLoaderClassName();
		try
		{
			Class<?> clazz = Class.forName(cacheLoaderClassName);
			Cacheable cacheLoader = (Cacheable) clazz.newInstance();
			if(cacheConfigVO.isPreload())
			{
				Object cache = cacheLoader.loadCache();
				cacheVO.setCachedObject(cache);
			}
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return cacheVO;
	}

	private List<CacheConfigVO>  loadCacheConfiguration()
	{
		List<CacheConfigVO> cacheConfigVOs = new ArrayList<CacheConfigVO>();
		CacheConfigEnum[] cacheConfigEnums = CacheConfigEnum.values();
		for (CacheConfigEnum cacheConfigEnum : cacheConfigEnums)
		{
			CacheConfigVO cacheConfigVO = new CacheConfigVO(
											cacheConfigEnum.getCacheId(), 
											cacheConfigEnum.getDescription(), 
											cacheConfigEnum.getCacheLoaderClassName(), 
											cacheConfigEnum.getRefreshInterval(), 
											cacheConfigEnum.isPreload()
											);
			cacheConfigVOs.add(cacheConfigVO);
		}
		return cacheConfigVOs;
	}
}
