package com.learning.tacocloud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Taco_Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	String id;
	String name;
	String city;
	String state;
	String ccNumber;
	String ccExpiration;
	String ccCVV;
	LocalDate placedAt;

	@ManyToMany(targetEntity = Taco.class)
	List<Taco> tacos = new ArrayList<>();

	public Order() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	public void addDesign(Taco design) {
		this.tacos.add(design);
	}

	@PrePersist
	public void placedAt() {
		this.placedAt = LocalDate.now();
	}
}
