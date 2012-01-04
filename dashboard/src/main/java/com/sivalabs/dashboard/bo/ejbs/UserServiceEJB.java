package com.sivalabs.dashboard.bo.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sivalabs.dashboard.bo.UserServiceEJBLocal;
import com.sivalabs.dashboard.model.User;

/**
 * Session Bean implementation class UserServiceEJB
 */
@Stateless
public class UserServiceEJB implements UserServiceEJBLocal
{
	@PersistenceContext(unitName = "sivalabsPU")
	private EntityManager em;
	
    public UserServiceEJB() {
    }
    
    @Override
    public String sayHello(String name)
	{
		return "Hellooo "+name;
	}
    @Override
	public User login(String username, String password)
    {
    	Query query = em.createQuery("select u from User u where u.username=? and u.password=?");
    	query.setParameter(1, username);
    	query.setParameter(2, password);
    	@SuppressWarnings("rawtypes")
		List list = query.getResultList();
    	if(list!=null && list.size()>0)
    	{
    		return (User) list.get(0);
    	}
    	return null;
    }
}
