package com.learning.dto;

import java.util.ArrayList;
import java.util.List;

import com.learning.entities.Ingredient;
import com.learning.entities.Taco;

public class TacoDTO {
	String name;
	List<Ingredient> ingredients;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	public static List<TacoDTO> getDtoFromEntity(List<Taco> tacoEntity){
		
		List<TacoDTO> tacoDTOList=new ArrayList<>();
		for(Taco taco:tacoEntity) {
			if(!taco.getName().isEmpty()) {
				TacoDTO tacoDTO=new TacoDTO();
				tacoDTO.setName(taco.getName());
				tacoDTO.setIngredients(taco.getIngredients());
				tacoDTOList.add(tacoDTO);
			}
		}
		return tacoDTOList;
		
	}
	
}
