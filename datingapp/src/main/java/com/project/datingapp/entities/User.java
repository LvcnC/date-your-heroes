package com.project.datingapp.entities;

public class User extends Entity{

	private String name;
	private String surname;
	private String username;
	private String password;
	private String dob;
	private short sex;
	
	public User() {
		
	}
	
	public User(String name, String surname, String username, String password,String dob, short sex) {
		setName(name);
		setSurname(surname);
		setUsername(username);
		setPassword(password);
		setDob(dob);
		setSex(sex);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public short getSex() {
		return sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}
	
	public String toString() {
		return super.toString() + " - " + name 	+ " - " + surname + " - " + username
								+ " - " + dob 	+ " - " + sex;
	}
	
	
	
}
