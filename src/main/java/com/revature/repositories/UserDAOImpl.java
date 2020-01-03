package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.revature.models.User;
import com.revature.util.CloseStreams;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

//	@Override
//	public boolean insertEmpl(User e) {
//		PreparedStatement stmt = null;
//		
//		try (Connection conn = ConnectionUtil.getConnection()) {
//			String sql = "INSERT INTO projectfun.employee (first_name, last_name, username, password) " +
//					"VALUES (?, ?, ?, ?, ?);";
//			
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, e.getFirstName());
//			stmt.setString(2, e.getLastName());
//			stmt.setString(3, e.getUsername());
//			stmt.setString(4, e.getPassword());
//			
//			if(!stmt.execute()) {
//				return false;
//			}
//		} catch(SQLException ex) {
//			logger.warn("Unable to retrieve all users", ex);
//			return false;
//		} finally {
//			CloseStreams.close(stmt);
//		}
//		
//		return true;
//---------------------------------------------------------------------------------------------	}
	
	@Override
	public boolean createUser(User user) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT into projectone.user0 (username, user_passward, user_fname, user_lname, user_email, user_role_id) " +
						"VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirst_name());
			stmt.setString(4, user.getLast_name());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getRole_id());
		
			boolean check = stmt.execute();
			if(check == false) {
				return true;
			}

		} catch (SQLException e) {
			logger.warn("Unable to create user in databse", e);
			e.printStackTrace();
		}
		return false;
	}


//	create table projectone.user0 (
//	user_id serial primary key,
//	username varchar(50) not null,
//	user_passward varchar(50) not null,
//	user_fname varchar(100) not null,
//	user_lname varchar(100) not null,
//	user_email varchar(150) not null,
//	user_role_id integer references projectone.user_role(role_id)
//	);

	@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM projectone.user0;";

			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
	
			while(rs.next()) {
				
				int user_id = rs.getInt("user_id");
				String first_name = rs.getString("user_fname");
				String last_name = rs.getString("user_lname");
				String username = rs.getString("username");
				String email = rs.getString("user_email");
				String password = rs.getString("user_passward");	
				int role_id = rs.getInt("user_role_id");
				
				list.add(new User(user_id, first_name, last_name, username, email, password, role_id));
			}
			
		} catch(SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		return list;
	}


	@Override
	public User getUserByUsername(String username) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM projectone.user0 WHERE username = ?;";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int user_id = rs.getInt("user_id");
				String first_name = rs.getString("user_fname");
				String last_name = rs.getString("user_lname");
				String username1 = rs.getString("username");
				String email = rs.getString("user_email");
				String password = rs.getString("user_passward");	
				int role_id = rs.getInt("user_role_id");

				User user = new User(user_id, first_name, last_name, username1, email, password, role_id);
				rs.close();
				return user;
			}
			
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve user from DB", e);
			e.printStackTrace();
		}
		return null;
	}
	 
}

