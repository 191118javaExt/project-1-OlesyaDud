package com.revature.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Reimbursement {
	private int reimb_id;
	private double reimb_amount;
	private Timestamp reimb_submitted;
	private Timestamp reimb_resolved;
	private String reimb_description;
	private byte[] reimb_receipt;
	private int reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;

	
	private String author;
	private String resolver;
	private String status;
	private String type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursement(int reimb_id, double reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public double getReimb_amount() {
		return reimb_amount;
	}


	public void setReimb_amount(double reimb_amount) {
		this.reimb_amount = reimb_amount;
	}


	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}


	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}


	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}


	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}


	public String getReimb_description() {
		return reimb_description;
	}


	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}


	public byte[] getReimb_receipt() {
		return reimb_receipt;
	}


	public void setReimb_receipt(byte[] reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}


	public int getReimb_author() {
		return reimb_author;
	}


	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}


	public int getReimb_resolver() {
		return reimb_resolver;
	}


	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}


	public int getReimb_status_id() {
		return reimb_status_id;
	}


	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}


	public int getReimb_type_id() {
		return reimb_type_id;
	}


	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getResolver() {
		return resolver;
	}


	public void setResolver(String resolver) {
		this.resolver = resolver;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt=" + Arrays.toString(reimb_receipt) + ", reimb_author=" + reimb_author
				+ ", reimb_resolver=" + reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id="
				+ reimb_type_id + ", author=" + author + ", resolver=" + resolver + ", status=" + status + ", type="
				+ type + ", getReimb_id()=" + getReimb_id() + ", getReimb_amount()=" + getReimb_amount()
				+ ", getReimb_submitted()=" + getReimb_submitted() + ", getReimb_resolved()=" + getReimb_resolved()
				+ ", getReimb_description()=" + getReimb_description() + ", getReimb_receipt()="
				+ Arrays.toString(getReimb_receipt()) + ", getReimb_author()=" + getReimb_author()
				+ ", getReimb_resolver()=" + getReimb_resolver() + ", getReimb_status_id()=" + getReimb_status_id()
				+ ", getReimb_type_id()=" + getReimb_type_id() + ", getAuthor()=" + getAuthor() + ", getResolver()="
				+ getResolver() + ", getStatus()=" + getStatus() + ", getType()=" + getType() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}