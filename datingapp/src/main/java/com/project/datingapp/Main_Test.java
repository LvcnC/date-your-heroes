package com.project.datingapp;

import java.util.Map;

import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.dao.Database;
import com.project.datingapp.entities.User;

public class Main_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Database db = new Database();
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
		DaoUsers du = new DaoUsers();

		User us = du.searchUser("cic0", "12345678");
		System.out.println(us);
		for(Map<String,String> m : du.read("SELECT name FROM users")) {
			System.out.println(m);
		}
		
		
	}

}
