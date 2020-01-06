package com.learning.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.rest.core.annotation.RestResource;

import com.learning.utilityclasses.DateUtil;


@Entity
@RestResource(path = "tacos", rel="tacos")
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
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	Date createdAt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="updated_at")
	Date updatedAt;
	
	@ManyToMany(targetEntity=Ingredient.class,cascade=CascadeType.PERSIST)
	@Size(min=1,message="Minimum 1 ingredient")
	List<Ingredient> ingredient;
	
	
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
	@PreUpdate
	void createdAt(){
		DateUtil dateUtil=new DateUtil();
		this.createdAt=dateUtil.convertToDatabaseColumn(LocalDate.now());
		this.updatedAt=dateUtil.convertToDatabaseColumn(LocalDate.now());
	}
	
	public Taco() {
	}
	
	
}
