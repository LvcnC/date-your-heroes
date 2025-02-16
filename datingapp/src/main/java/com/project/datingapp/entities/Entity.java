package com.project.datingapp.entities;

public abstract class Entity {

	private int id;
	
	public Entity() {
		
	}
	
	public Entity(int id) {
		setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id + "";
	}
	
}
