package com.project.datingapp.entities;

public class Character extends Person{

    private String historicalPeriod;

    public Character(){

    }

    public Character(String name, String surname, String username, 
                    String dob, short sex, String historicalPeriod){
        super(name, surname, username,dob,sex);
        setHistoricalPeriod(historicalPeriod);
    }

    public String getHistoricalPeriod() {
        return historicalPeriod;
    }

    public void setHistoricalPeriod(String historicalPeriod) {
        this.historicalPeriod = historicalPeriod;
    }

    public String toString() {
		return super.toString() + " - " + historicalPeriod;
	}

}
