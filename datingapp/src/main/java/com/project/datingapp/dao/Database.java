package com.project.datingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database
{

	private Connection c;
	private String path = "jdbc:mysql://localhost:3306/" + "datingapp" + "?";
	private String username= "root";
	private String password = "root";


	public void openConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			c = DriverManager.getConnection(path,username,password);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void closeConnection() {

		try {
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}


	public Connection getC() {
		return this.c;
	}

	public boolean update(String query, String...params) {

		try {

			openConnection();
			PreparedStatement ps = c.prepareStatement(query);
			for(int i = 0; i < params.length; i++) {
					
				ps.setString(i + 1, params[i]);

			}

			ps.executeUpdate();
			ps.close();

			return true;

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			closeConnection();
		}

	}

	public List<Map<String,String>> rows(String query, String...params){

		List<Map<String,String>> ris = new ArrayList<Map<String,String>>();
		PreparedStatement ps = null;

		try {

			openConnection();
			ps = c.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++) {
				// nella posizione 1 (causa SQL), mettici il parametro [0]
				ps.setString(i + 1, params[i]);

			}
			System.out.println(ps.toString());
			
			ResultSet table = ps.executeQuery();
			int nColumns = table.getMetaData().getColumnCount();

			while(table.next()) {

				Map<String,String> map = new HashMap<String, String>();

				for(int i = 1; i <= nColumns; i++) {
					map.put(table.getMetaData().getColumnLabel(i), table.getString(i));

				}
				ris.add(map);

			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		closeConnection();
		return ris;
	}

	public Map<String,String> row(String query, String...params){
		try {
			return rows(query,params).get(0);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
