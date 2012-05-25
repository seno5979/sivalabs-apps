/**
 * 
 */
package com.sivalabs.jforum.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Siva
 *
 */
public abstract class CrudServiceBean<T> implements CrudDAO<T>
{
	
	private Class<T> clazz;
	
	public CrudServiceBean(Class<T> clazz)
	{
		this.clazz = clazz;
	}
	
	public abstract EntityManager getEntityManager();
	
	@Override
	public T save(T obj)
	{
		getEntityManager().persist(obj);
		return obj;
	}

	@Override
	public T findByID(Serializable id)
	{
		System.out.println("Executing DB query to fetch "+clazz+" entity by id:"+id);
		//getEntityManager().clear();
		//Map<String, Object> props = new HashMap<String, Object>();
		//props.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
		return getEntityManager().find(clazz, id);
	}

	@Override
	public List<T> findAll()
	{
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void update(T obj)
	{
		if(obj!=null)
		{
			getEntityManager().merge(obj);
		}
		
	}

	@Override
	public void delete(T obj)
	{
		if(obj!=null)
		{
			getEntityManager().remove(obj);
		}
	}

	@Override
	public void delete(Serializable id)
	{
		T obj = this.findByID(id);
		if(obj !=null){
			getEntityManager().remove(obj);
		}
	}

}
