 package com.revature.services;

import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.UserDAOImpl;

public class UserService {
	
	static UserDAOImpl uDAOImp = new UserDAOImpl();
	public static User verifyLogin(String username, String password) {
		return uDAOImp.verifyLogin(username, password);
	}
	
	public static UserDTO convertToDTO(User u) {
		return new UserDTO(u.getUser_id(),
				u.getFirst_name(),
				u.getLast_name(),
				u.getUsername(),
				u.getPassword());
	}
	
	public User getUserReimb(User model) {
		return uDAOImp.getUserReimb(model);
	}
}