package com.sivalabs.resteasydemo;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sivalabs.resteasydemo.MockUserTable;

@Service
public class UserService 
{

	public void save(User user){
		MockUserTable.save(user);
	}

	public User getById(Integer id){
		return MockUserTable.getById(id);
	}

	public List<User> getAll(){
		return MockUserTable.getAll();
	}
	public void delete(Integer id){
		if(id!=null && id == 1){
			throw new ApplicationException("Admin User can't be deleted.");
		}
		MockUserTable.delete(id);
	}
}