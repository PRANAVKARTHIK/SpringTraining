package com.learning.entities;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.learning.utilityclasses.dateutilities.TimestampUtil;

@Entity
@Table(name="taco_user")
public class TacoUser {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="username")
	String username;
	
	@Column(name="pwd")
	String password;
	
	@Column(name="user_role")
	String userRole;
	
	Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}  
	
	@PrePersist
	public void createdAt(){
		TimestampUtil timeStampUtil=new TimestampUtil();
		this.createdAt=timeStampUtil.convertToDatabaseColumn(LocalDateTime.now());
	}
	
}
