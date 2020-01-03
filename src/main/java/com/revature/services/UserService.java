package com.revature.services;

import java.util.List;


import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.UserDAOImpl;

public class UserService {

	public static boolean createUser(User u) {
		return new UserDAOImpl().createUser(u);
	}
	
	public static List<User> findAll() {
		return new UserDAOImpl().findAll();
	}
	
	public static User getUserByUsername(User username) {
		List<User> all = new UserDAOImpl().getUserByUsername(username);
		
		for(User u : all) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		
		return null;
	}
	
	public static User confirmLogin(String username, String password) {
		User u = getUserByUsername(username);
		if(u == null) {
			return null;
		}
		if(u.getPassword().equals(password)) {
			return u;
		} else {
			return null;
		}
	}
	
	public static UserDTO convertToDTO(User u) {
		return new UserDTO(u.getUser_id(),
				u.getFirst_name(),
				u.getLast_name(),
				u.getUsername(),
				u.getPassword());
	}
}