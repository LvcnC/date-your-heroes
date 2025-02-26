package com.project.datingapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.project.datingapp.entities.User;

public class DaoUsers
{

	@Autowired
	private Database db = new Database();
	
	@Autowired
	private ApplicationContext context;
	
	public List<Map<String,String>> readAll(){
		String query = "SELECT * FROM users";
		return db.rows(query);
	}
	
	public List<Map<String,String>> read(String query, String...params){
		return db.rows(query, params);
	}
	
	public Map<String,String> readUser(String query, String...params){
		return db.row(query, params);
	}
	
	public boolean create(User user) {
		
		String query = "INSERT INTO users \r\n"
				+ "(name,surname,username,password,dob,sex,sexualOrientation)\r\n"
				+ "values\r\n"
				+ "(?,?,?,?,?,?,?)";
		
		return db.update(query, user.getName(), user.getSurname(), user.getUsername(), 
								user.getPassword(), user.getDob(), user.getSex() + "", user.getSexualOrientation());
		
	}
	
	
	public boolean update(User user) {
		
		String query = "UPDATE users\r\n"
				+ "SET name = ?,\r\n"
				+ "	surname = ?,\r\n"
				+ "    username = ?,\r\n"
				+ "		password = ?,\r\n"
				+ "    dob = ?,\r\n"
				+ "    sex = ?,\r\n"
				+ "    sexualOrientation = ?\r\n"
				+ "WHERE id = ?";
		
		return db.update(query, user.getName(), user.getSurname(), user.getUsername(),
								user.getPassword(), user.getDob(), user.getSex() + "" , 
								user.getSexualOrientation(),user.getId() + "");
	}
	
	public boolean delete(int id) {
		
		String query = "DELETE FROM users WHERE id = ?";
		
		return db.update(query, id + "");
	}
	
	public User searchForId(int id) {
		
		String query = "SELECT * FROM users WHERE id = ?";
		Map<String,String> mapUser = db.row(query, id + "");
		
		// we CREATE (factory!!) the object User
		// and then we (reflection) FILL the object with the values from the map
		User us = (User) context.getBean("userObject", mapUser);
		
		/*
		User us = new User();
		us.setId(Integer.parseInt(mapUser.get("id")));
		us.setName(mapUser.get("name"));
		us.setSurname(mapUser.get("surname"));
		us.setUsername(mapUser.get("username"));
		us.setPassword(mapUser.get("password"));
		us.setDob(mapUser.get("dob"));
		us.setSex(Short.parseShort(mapUser.get("sex")));
		*/
		
		return us;
	}
	
	public User searchUser(String username, String password) {
		
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		Map<String,String> mapUser = readUser(query, username,password);
		
		User us = (User) context.getBean("userObject", mapUser);
		/*
		User us = new User();
		us.setId(Integer.parseInt(mapUser.get("id")));
		us.setName(mapUser.get("name"));
		us.setSurname(mapUser.get("surname"));
		us.setUsername(mapUser.get("username"));
		us.setPassword(mapUser.get("password"));
		us.setDob(mapUser.get("dob"));
		us.setSex(Short.parseShort(mapUser.get("sex")));
		*/
		return (us != null) ? us : null;
	}

	/**it returns every interests of a specified user
	 * 
	 * @param username
	 * @return ArrayList<String> of the interests
	 */
	public ArrayList<String> interests(String username){
		String query = "SELECT " + 
						"\t\t\tinterests.name as 'interest'\n" + 
						"FROM\t\tinterests INNER JOIN user_interest\n" + 
						"ON\t\t\tinterests.id = user_interest.idInterest\n" + 
						"INNER JOIN\tusers\n" + 
						"ON\t\t\tusers.id = user_interest.idUser\n" + 
						"WHERE \t\tusers.username = ?";
		return db.rowsArrayList(query, username);
	}
	
	
	
}
