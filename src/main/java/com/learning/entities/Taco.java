package com.learning.entities;

import java.time.LocalDateTime;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;

import com.learning.utilityclasses.dateutilities.TimestampUtil;


@Entity
@RestResource(path = "tacos", rel="tacos")
public class Taco {
	
	@Autowired
	@Transient
	TimestampUtil timestampUtil;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="id",columnDefinition = "text")
	String id;
	
	@NotNull
	@Size(min=5,message="Minimum 5 characters long")
	@Column(name="name")
	String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
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
		
		this.createdAt=timestampUtil.convertToDatabaseColumn(LocalDateTime.now());
		this.updatedAt=timestampUtil.convertToDatabaseColumn(LocalDateTime.now());
	}
	
	public Taco() {
	}
	
	
}
