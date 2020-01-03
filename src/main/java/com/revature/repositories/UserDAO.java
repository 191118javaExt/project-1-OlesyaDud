package com.revature.repositories;

import java.util.List;
import com.revature.models.User;
import com.revature.models.UserRole;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User getUserByUsername(String username);
	
//	public boolean getUserById (int userId);
	
	public boolean createUser (User user);
}
