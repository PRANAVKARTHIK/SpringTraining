package com.learning.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entities.Ingredient;
import com.learning.entities.Ingredient.IngType;
import com.learning.utilityclasses.Constants;

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
	
	public static List<Ingredient> setIngredientEntityFromDTO(List<String> ingredientList){
		List<Ingredient> ingredientEntityList=ingredientList.stream().map(ing->Constants.nameMapper.get(ing)).collect(Collectors.toList());
		return ingredientEntityList;
	}
	
	public static String getIdByName(String name) {
		HashMap<String,String> nameMapper=new HashMap<>() ;
		nameMapper.put("Carnitas", "CARN");
		nameMapper.put("Cheddar", "CHED");
		nameMapper.put("Corn Tortilla", "COTO");
		nameMapper.put("Flour Tortilla", "FLTO");
		nameMapper.put("Ground Beef", "GRBF");
		nameMapper.put("Monterrey Jack", "JACK");
		nameMapper.put("Lettuce", "LETC");
		nameMapper.put("Salsa", "SLSA");
		nameMapper.put("Sour Cream", "SRCR");
		nameMapper.put("Diced Tomatoes", "TMTO");
		
		return nameMapper.get(name);
	}
}
