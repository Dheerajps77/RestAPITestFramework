package com.qa.restapi.data;

public class UserData {
	
	String userFirstName;
	String userSecondName;
	String id;
	String createdAt;
	
	public UserData()
	{
		
	}
	
	public UserData(String userFirstName, String userSecondName)
	{
		this.userFirstName=userFirstName;
		this.userSecondName=userSecondName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserSecondName() {
		return userSecondName;
	}

	public void setUserSecondName(String userSecondName) {
		this.userSecondName = userSecondName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	
	

}
