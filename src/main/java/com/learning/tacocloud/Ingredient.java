package com.learning.tacocloud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
	
	@Id
	public String id;
	public String name;
	public Type type;
	
	public static enum Type{
		Wrap,Proteins,Veggies,Cheese,Sause
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	
}
