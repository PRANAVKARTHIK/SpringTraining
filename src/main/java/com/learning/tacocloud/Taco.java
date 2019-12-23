package com.learning.tacocloud;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import utilityclasses.DateUtil;


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
	List<Ingredient> ingredient;
	
	@Temporal(TemporalType.DATE)
	@Column(name="createdAt")
	Date createdAt;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredients() {
		return ingredient;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredient = ingredients;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@PrePersist
	void createdAt(){
		DateUtil dateUtil=new DateUtil();
		this.createdAt=dateUtil.convertToDatabaseColumn(LocalDate.now());
	}
	
	public Taco() {
	}
	
	
}
