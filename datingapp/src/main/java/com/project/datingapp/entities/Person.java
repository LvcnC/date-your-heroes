package com.project.datingapp.entities;

public abstract class Person extends Entity{

    private String name;
	private String surname;
	private String username;
	private String dob;
	private short sex;

    public Person(){

    }

    public Person(String name, String surname, String username,String dob, short sex) {
		setName(name);
		setSurname(surname);
		setUsername(username);
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
