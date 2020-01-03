package com.revature.repositories;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbStatus;
import com.revature.util.ConnectionUtil;



public class ReimbDAOImpl implements ReimbursementDAO {
	
	private static Logger logger = Logger.getLogger(ReimbDAOImpl.class);

	
//	reimb_id serial primary key,
//	reimb_amount serial not null,
//	reimb_submitted timestamp not null,
//	reimb_resolved timestamp not null,
//	reimb_description varchar(250),
//	reimb_receit bytea null,
//	reimb_author integer references projectone.user0(user_id),
//	reimb_resolver integer references projectone.user0(user_id),
//	reimb_status_id integer references projectone.reimb_status(status_id),
//	reimb_type_id integer references projectone.reimb_type(type_id)
//	---------------------------------------



	@Override
	public boolean submitReimb(Reimbursement reimb) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT into projectone.reimbursement(reimb_amount, reimb_submitted, reimb_resolved, "
					+ "reimb_discription, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, reimb.getReimb_amount());
			stmt.setTimestamp(2, Timestamp.valueOf(reimb.getSubmitted()));
			stmt.setTimestamp(3, Timestamp.valueOf(reimb.getResolved()));
			stmt.setString(4, reimb.getReimb_description());
			stmt.setBytes(5, reimb.getReimb_receipt());
			stmt.setInt(6, reimb.getReimb_author());
			stmt.setInt(7, reimb.getReimb_id());
			stmt.setInt(8, reimb.getReimb_status_id());
			stmt.setInt(9, reimb.getReimb_type_id());

			boolean check = stmt.execute();
			if (check == false) {
				return true;
			}

		} catch (SQLException e) {
			logger.warn("Reimbursement cannot be submitted.", e);
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean denyReimb(int reimb_id, int reimb_resolver) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE projectone.reimbursement SET reimb_status_id = -1, reimb_resolver = (?) WHERE reimb_id= (?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, reimb_resolver);
			stmt.setInt(2, reimb_id);
			
			if(!stmt.execute()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.warn("Reimbursement is not approved. ");
		}
		return false;

	}
	

	@Override
	public boolean approveReimb(int reimb_id, int reimb_resolver) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE projectone.reimbursement SET reimb_status_id = 1, reimb_resolver = (?) WHERE reimb_id= (?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, reimb_resolver);
			stmt.setInt(2, reimb_id);
			
			if(!stmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.warn("Reimbursement is not approved.");
		}
		return false;
	}


	@Override
	public List<Reimbursement> findAllReimb() {
		return null;
	}


	@Override
	public Reimbursement findReimbById(int reimb_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
