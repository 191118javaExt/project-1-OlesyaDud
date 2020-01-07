package com.revature.repositories;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	private enum QueryType{
		verifyUser,
		selectUserById,
		getUserReimb
	}
	private User queryDB(String query, Object[] params, QueryType qType, User model) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = query;

			PreparedStatement stmt = conn.prepareStatement(sql);
			switch(qType) {
				case selectUserById:
					stmt.setObject(1, params[0]);
					break;
				case verifyUser:
					stmt.setObject(1, params[0]);
					stmt.setObject(2, params[1]);
					break;
				case getUserReimb:
					stmt.setObject(1, params[0]);
					break;					
			}
			
			ResultSet rs = stmt.executeQuery();
			
			List<Reimbursement> reimbList = new ArrayList<>();
			
			while (rs.next()) {
				if (qType == QueryType.verifyUser || qType == QueryType.selectUserById) {
					int user_id = rs.getInt("user_id");
					String first_name = rs.getString("user_fname");
					String last_name = rs.getString("user_lname");
					String username = rs.getString("username");
					String email = rs.getString("user_email");
					String password = rs.getString("user_passward");
					int role_id = rs.getInt("user_role_id");
	
					model = new User(user_id, first_name, last_name, username, email, password, role_id);
				} else if (qType == QueryType.getUserReimb) {
					
					
					int reimb_id = rs.getInt("reimb_id");
					double reimb_amount = rs.getDouble("reimb_amount");
					Timestamp reimb_submitted = rs.getTimestamp("reimb_submitted");
					Timestamp reimb_resolved = rs.getTimestamp("reimb_resolved");
					String reimb_description = rs.getString("reimb_description");
					
					Reimbursement reimbModel = new Reimbursement(reimb_id, reimb_amount, reimb_submitted, 
							reimb_resolved, reimb_description);
					
					
					reimbList.add(reimbModel);
				}
				
			}

		} catch (SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}
		return model;
	}
	
//	@Override
//	public List<User> findAll() {
//		
//		List<User> list = new ArrayList<>();
//		String sqlStr = "SELECT * FROM projectone.user0;";
//		queryDB(sqlStr);
//		
//		return list;
//	}	

	public User getUserById(int id) {
		User user = null;
		String sqlStr = 
				"SELECT * FROM projectone.user0\r\n" + 
				"where id = ?;";
		user = queryDB(sqlStr, new Object[] { id }, QueryType.selectUserById, null);
		
		return user;
	}

	
	public User verifyLogin(String username, String pass) {
		User user = null;
		boolean isLoggedIn = false;
		String sqlStr = 
				"SELECT * FROM projectone.user0\r\n" + 
				"where username = ? and user_passward = ?;";
		user = queryDB(sqlStr, new Object[] { username, pass }, QueryType.verifyUser, null);
		
		return user;
	}
	
	public User getUserReimb(User model) {
		User user = null;
		boolean isLoggedIn = false;
		String sqlStr = 
				"select * from projectone.reimbursement where reimb_author = ?;";
		user = queryDB(sqlStr, new Object[] { model.getUser_id() }, QueryType.getUserReimb, model);
		
		return user;
	}
	
}