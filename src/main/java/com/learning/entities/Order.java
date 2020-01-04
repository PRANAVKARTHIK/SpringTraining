package com.learning.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.learning.utilityclasses.dateutilities.TimestampUtil;

@Entity
@Table(name = "Taco_Order")
public class Order {

	@Autowired
	@Transient
	TimestampUtil timestampUtil;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", columnDefinition = "text")
	String id;

	@Column(name = "delivery_name")
	String name;

	@Column(name = "delivery_city")
	String city;
	@Column(name = "delivery_state")
	String state;
	
	@Column(name = "cc_number")
	String ccNumber;
	
	@Column(name = "cc_expiration")
	String ccExpiration;
	
	@Column(name = "cc_cvv")
	String ccCVV;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "placed_at")
	Date placedAt;

	@ManyToMany(targetEntity = Taco.class)
	List<Taco> tacos = new ArrayList<>();

	public Order() {
		// For Hibernate
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
		this.placedAt = timestampUtil.convertToDatabaseColumn(LocalDateTime.now());
	}
}
