package com.project.datingapp;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.project.datingapp.dao.DaoCharacters;
import com.project.datingapp.dao.DaoImages;
import com.project.datingapp.dao.DaoUsers;
import com.project.datingapp.dao.Database;
import com.project.datingapp.entities.*;
import com.project.datingapp.entities.HistoryCharacter;

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
	DaoCharacters dc(){
		return new DaoCharacters();
	}
	
	@Bean
	DaoImages di(){
		return new DaoImages();
	}

	@Bean
	@Scope("prototype")
	public User userNew(Map<String,String> map) {
		
		User us = new User();
		//us.setId(0);
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
	public HistoryCharacter characterFromMap(Map<String,String> map){

		HistoryCharacter character = new HistoryCharacter();
		character.setId(Integer.parseInt(map.get("character_id")));
		character.setName(map.get("name"));
		character.setSurname(map.get("surname"));
		character.setUsername(map.get("username"));
		character.setDob(map.get("dob"));
		character.setSex(Short.parseShort(map.get("sex")));
		character.setHistoricalPeriod(map.get("historicalPeriod"));
		
		return character;
	}

	@Bean
	@Scope("prototype")
	public Image imageFromMap(Map<String,String> map){
		Image im = new Image();
		im.setId(Integer.parseInt(map.get("image_id")));
		im.setOwnerType(map.get("owner_type"));
		im.setOwnerId(Integer.parseInt(map.get("owner_id")));
		im.setImageUrl(map.get("image_url"));
		im.setDescription(map.get("description"));
		im.setCreatedAt(map.get("create_at"));

		return im;
	}

}
