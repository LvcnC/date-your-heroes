package com.project.datingapp.maintest;

import java.util.Map;

import com.project.datingapp.dao.*;

public class Main_Test {

	public static void main(String[] args) {
//C:\Users\newmi\meet_your_heros\date-your-heros\datingapp(2)\datingapp\src\main\java\com\project\datingapp\dao
		/*
		Map<String,String> user = new HashMap<String, String>();
		user.put("name", "topogiggio");
		user.put("surname", "rossi");
		user.put("username", "topo60");
		user.put("dob", "2000-12-12");
		user.put("sex", "0");
		user.put("surname", "rossi");
		db.update("UPDATE users SET surname = ? WHERE id = 1", user.get("surname"));
		*/
		/*
		DaoUsers du = new DaoUsers();
		User us = du.searchForId(1);
		System.out.println("dio stronzo");
		for(Interest s : du.interests(us.getName())){
			System.out.println("result " + s.getInterest());
		}		
		*/
		DaoUsers du = new DaoUsers();
		for(Map<String,String> record : du.getMatchingCharacters(2))
		{
			System.out.println(record.get("interest"));
			System.out.println(record.get("character"));
	  	}
	}

}
