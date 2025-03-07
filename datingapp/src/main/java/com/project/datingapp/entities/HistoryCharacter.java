package com.project.datingapp.entities;

public class HistoryCharacter extends Person{

    private String historicalPeriod;

    public HistoryCharacter(){

    }

    public HistoryCharacter(String name, String surname, String username, 
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
