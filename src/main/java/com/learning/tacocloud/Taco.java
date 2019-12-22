package com.learning.tacocloud;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Taco {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id",columnDefinition = "text")
	String id;
	
	@NotNull
	@Size(min=5,message="Minimum 5 characters long")
	@Column(name="name")
	String name;
	
	@ManyToMany(targetEntity=Ingredient.class)
	@Size(min=1,message="Minimum 1 ingredient")
	@Column(name="ingredient_list")
	List<String> ingredients;
	
	@Column(name="createdAt")
	LocalDate createdAt;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@PrePersist
	void createdAt(){
		this.createdAt=LocalDate.now();
	}
	
	public Taco() {
	}
	
	
}
