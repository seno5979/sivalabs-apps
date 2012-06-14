/**
 * 
 */
package com.sivalabs.jforum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sivalabs.jforum.entities.User;
import com.sivalabs.jforum.entities.UserLogon;

/**
 * @author Siva
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

	@Query("select u from User u where u.userLogon.userName=?1 and u.userLogon.password=?2")
	UserLogon login(String userName, String password);

	@Query("update User u set u.userLogon.password=?3 where u.userId=?1 and u.userLogon.password=?2")
	int changePwd(Integer userId, String pwd, String newPwd);
	
}
