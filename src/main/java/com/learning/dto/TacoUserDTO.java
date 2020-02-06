package com.learning.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.learning.entities.TacoUser;

public class TacoUserDTO {

	@JsonInclude(value = Include.NON_NULL)
	int id;
	String username;
	String password;
	@JsonInclude(value = Include.NON_NULL)
	String userRole;
	@JsonInclude(value = Include.NON_NULL)
	Date createAt;

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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static TacoUser getEntityFromDTO(TacoUserDTO tacoUserDto) {

		TacoUser tacoUser = new TacoUser();
		tacoUser.setUsername(tacoUserDto.getUsername());
		tacoUser.setPassword(tacoUserDto.getPassword());
		return tacoUser;
	}

}
