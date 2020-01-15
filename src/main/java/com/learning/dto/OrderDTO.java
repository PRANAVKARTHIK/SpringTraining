package com.learning.dto;

import java.util.ArrayList;
import java.util.List;

import com.learning.entities.Order;
import com.learning.entities.Taco;

public class OrderDTO {

	String deliveryName;
	String deliveryCity;
	String deliveryState;
	String ccNumber;
	String ccExpiration;
	String ccCVV;
	
	TacoDTO tacoDTO;
	
	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
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

	public TacoDTO getTacoDTO() {
		return tacoDTO;
	}

	public void setTacoDTO(TacoDTO tacoDTO) {
		this.tacoDTO = tacoDTO;
	}

	
	public static Order getEntityFromDTO(OrderDTO orderDTO){
		Order orderEntity=new Order();
		orderEntity.setName(orderDTO.getDeliveryName());
		orderEntity.setCity(orderDTO.getDeliveryCity());
		orderEntity.setState(orderDTO.getDeliveryState());
		orderEntity.setCcCVV(orderDTO.getCcCVV());
		orderEntity.setCcExpiration(orderDTO.getCcExpiration());
		orderEntity.setCcNumber(orderDTO.getCcNumber());
		
		List<Taco> tacoList=new ArrayList<>();
		tacoList.add(TacoDTO.getEntityFromDTO(orderDTO.getTacoDTO()));
		orderEntity.setTacos(tacoList);
		return orderEntity;
	}
	
	public void getDTOFromEntity(){
		
	}
}
