package com.learning.dto;

import java.util.ArrayList;
import java.util.List;

import com.learning.entities.Ingredient;

public class IngredientDTO {
	
	String name;
	String ingType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIngType() {
		return ingType;
	}

	public void setIngType(String ingType) {
		this.ingType = ingType;
	}

	public static List<IngredientDTO> getIngredientListWithoutId(List<Ingredient> ingredientEntityList){
		List<IngredientDTO> ingredientList=new ArrayList<>();
		IngredientDTO ingredientDTo;
		for(Ingredient i:ingredientEntityList){
			ingredientDTo=new IngredientDTO();
			ingredientDTo.setName(i.getName());
			ingredientDTo.setIngType(i.getType().toString());
			ingredientList.add(ingredientDTo);
		}
		return ingredientList;
	}
}
