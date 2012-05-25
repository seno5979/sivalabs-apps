/**
 * 
 */
package com.sivalabs.jforum.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Siva
 *
 */
public interface CrudDAO<T>
{
	public T save(T obj);
	public T findByID(Serializable id);
	public List<T> findAll();
	public void update(T obj);
	public void delete(T obj);
	public void delete(Serializable id);	
}
