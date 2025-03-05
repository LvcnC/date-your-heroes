package com.project.datingapp;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.dao.Database;
import com.project.datingapp.entities.*;
import com.project.datingapp.entities.Character;

@Configuration
public class Context {

	@Bean
	public Database db() {
		return new Database();
	}
	
	
	@Bean 
	DaoUsers du() {
		return new DaoUsers();
	}
	
	
	@Bean
	@Scope("prototype")
	public User userObject(Map<String,String> map) {
		
		User us = new User();
		us.setId(Integer.parseInt(map.get("user_id")));
		us.setName(map.get("name"));
		us.setSurname(map.get("surname"));
		us.setUsername(map.get("username"));
		us.setPassword(map.get("password"));
		us.setDob(map.get("dob"));
		us.setSex(Short.parseShort(map.get("sex")));
		us.setSexualOrientation(map.get("sexualOrientation"));
		
		return us;
	}
	
	@Bean
	@Scope("prototype")
	public Interest interestFromMap(Map<String,String> map){

		Interest interest = new Interest();
		interest.setId(Integer.parseInt(map.get("interest_id")));
		interest.setInterest(map.get("name"));

		return interest;
	}

	@Bean
	@Scope("prototype")
	public Character characterFromMap(Map<String,String> map){

		Character character = new Character();
		character.setId(Integer.parseInt(map.get("character_id")));
		character.setName(map.get("name"));
		character.setSurname(map.get("surname"));
		character.setUsername(map.get("username"));
		character.setDob(map.get("dob"));
		character.setSex(Short.parseShort(map.get("sex")));
		character.setHistoricalPeriod(map.get("historicalPeriod"));
		
		return character;
	}

}
