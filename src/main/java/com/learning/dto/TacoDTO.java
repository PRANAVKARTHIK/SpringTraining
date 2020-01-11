package com.learning.dto;

import java.util.ArrayList;
import java.util.List;

import com.learning.entities.Taco;

public class TacoDTO {
	String name;
	List<String> ingredients;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public TacoDTO() {
		super();
	}
//	public static List<TacoDTO> getDtoFromEntity(List<Taco> tacoEntity){
//		
//		List<TacoDTO> tacoDTOList=new ArrayList<>();
//		for(Taco taco:tacoEntity) {
//			if(!taco.getName().isEmpty()) {
//				TacoDTO tacoDTO=new TacoDTO();
//				tacoDTO.setName(taco.getName());
//				tacoDTO.setIngredients(IngredientDTO.getIngredientListWithoutId(taco.getIngredients()));
//				tacoDTOList.add(tacoDTO);
//			}
//		}
//		return tacoDTOList;
//		
//	}
	
	public static Taco getEntityFromDTO(TacoDTO tacoDTO){
		Taco taco=new Taco();
		taco.setName(tacoDTO.getName());
		taco.setIngredients(IngredientDTO.setIngredientEntityFromDTO(tacoDTO.getIngredients()));
		return taco;
	}
	
}
