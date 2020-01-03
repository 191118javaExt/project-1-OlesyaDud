package com.revature.models;

public class ReimbStatus {

	public int statusId;
	public String reimbStatus;
	public ReimbStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbStatus(int statusId, String reimbStatus) {
		super();
		this.statusId = statusId;
		this.reimbStatus = reimbStatus;
	}
	@Override
	public String toString() {
		return "ReimbStatus [statusId=" + statusId + ", reimbStatus=" + reimbStatus + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	
}
