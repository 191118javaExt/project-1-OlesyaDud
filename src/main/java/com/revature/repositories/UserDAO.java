package com.revature.repositories;

import com.revature.models.User;

public interface UserDAO {	
	public User getUserById(int id);
	public User verifyLogin(String username, String pass);
}
