package com.revature.repositories;

import java.util.List;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public List<Reimbursement> findAllReimb();
	public Reimbursement findReimbById(int reimb_id);
	public boolean submitReimb(Reimbursement reimb);
	public boolean denyReimb(int reimb_id, int reimb_resolver);
	public boolean approveReimb(int reimb_id, int reimb_resolver);

}
