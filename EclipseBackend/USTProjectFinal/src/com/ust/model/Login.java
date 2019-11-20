package com.ust.model;

public class Login 
{

//Instance Variables
	
	private int userId;
	private String userName;
	private String password;
	
//Default Constructor
	
	public Login()
	{
		super();
	}
	
//Parameterized Constructor
	
	public Login(int userId, String userName, String password) 
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	
//Getters and Setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
}
