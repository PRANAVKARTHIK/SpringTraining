package com.learning.dto;

import java.util.ArrayList;
import java.util.List;

import com.learning.entities.Ingredient;

public class IngredientDTO {
	
	String id;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public static List<Ingredient> setIngredientEntityFromDTO(List<IngredientDTO> ingredientDTO){
		List<Ingredient> ingredientList=new ArrayList<>();
		Ingredient ingredient;
		for(IngredientDTO idto:ingredientDTO){
			ingredient=new Ingredient();
			ingredient.setId(idto.getId());
			ingredient.setName(idto.getName());
			ingredient.setType(Ingredient.IngType.valueOf(idto.getIngType()));
			ingredientList.add(ingredient);
		}
		return ingredientList;
	}
}
