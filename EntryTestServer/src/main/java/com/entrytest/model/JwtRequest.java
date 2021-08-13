package com.entrytest.model;


	public class JwtRequest{
		String userName;
		String userPassword;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
		
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public JwtRequest() {
			super();
			// TODO Auto-generated constructor stub
		}
		public JwtRequest(String userName, String userPassword) {
			super();
			this.userName = userName;
			this.userPassword = userPassword;
		}
		
	}
	


