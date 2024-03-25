package com.swetha.librarymanagement.model;

public class User {
	String name;
	String email;
	String phoneNumber;
	String password;
	public void setUserName(String userName) {
		this.name=userName;	
	}

	public void setEmailId(String emailId) {
		this.email=emailId;
	}

	public void setPassword(String password) {
		this.password=password;
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

    public String getEmail() {
		return email;
    }
}
