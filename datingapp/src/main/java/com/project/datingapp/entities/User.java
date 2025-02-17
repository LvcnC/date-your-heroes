package com.project.datingapp.entities;

public class User extends Person{

	private String password;
	private String sexualOrientation;

	public User() {
		
	}
	
	public User(String name, String surname, String username, 
				String password,String dob, short sex, String sexualOrientation) {
		super(name, surname, username,dob,sex);
		setPassword(password);
		setSexualOrientation(sexualOrientation);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexualOrientation() {
		return sexualOrientation;
	}

	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}
	
	public String toString() {
		return super.toString() + " - " + sexualOrientation;
	}
	
}
