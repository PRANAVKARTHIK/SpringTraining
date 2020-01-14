package com.learning.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ingredient")
public class Ingredient {
	@Id
	@Column(name="id")
	public String id;
	
	@Column(name="name")
	public String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	public IngType type;
	
	public static enum IngType{
		Wrap,Proteins,Veggies,Cheese,Sauce
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

	public IngType getType() {
		return type;
	}

	public void setType(IngType type) {
		this.type = type;
	}

	public Ingredient() {
		super();
	}

	public Ingredient(String id, String name, IngType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	

	
}
