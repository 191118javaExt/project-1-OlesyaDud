package com.revature.models;

public class UserRole {

		private int role_id;
		private String user_role;
		public UserRole() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserRole(int role_id, String user_role) {
			super();
			this.role_id = role_id;
			this.user_role = user_role;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + role_id;
			result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserRole other = (UserRole) obj;
			if (role_id != other.role_id)
				return false;
			if (user_role == null) {
				if (other.user_role != null)
					return false;
			} else if (!user_role.equals(other.user_role))
				return false;
			return true;
		}
		public int getRole_id() {
			return role_id;
		}
		public void setRole_id(int role_id) {
			this.role_id = role_id;
		}
		public String getUser_role() {
			return user_role;
		}
		public void setUser_role(String user_role) {
			this.user_role = user_role;
		}
		
		
	
	}
