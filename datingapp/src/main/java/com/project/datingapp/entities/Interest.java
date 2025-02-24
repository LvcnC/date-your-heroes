package com.project.datingapp.entities;

public class Interest
{
    private String interest;

    public Interest(){
    }

    public Interest(String interest){
        setInterest(interest);
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String toString(){
        return interest;
    }
}
