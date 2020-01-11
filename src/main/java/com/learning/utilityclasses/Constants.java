package com.learning.utilityclasses;

import java.util.HashMap;

import com.learning.entities.Ingredient;
import com.learning.entities.Ingredient.IngType;

public class Constants {

	public static final HashMap<String,Ingredient> nameMapper=new HashMap<>() ;
	static{
	nameMapper.put("CARN",new Ingredient("CARN","Carnitas",IngType.Proteins) );
	nameMapper.put("CHED",new Ingredient("CHED","Cheddar",IngType.Proteins));
	nameMapper.put("COTO",new Ingredient("COTO","Corn Tortilla",IngType.Wrap));
	nameMapper.put("FLTO",new Ingredient("FLTO","Flour Tortilla",IngType.Wrap));
	nameMapper.put("GRBF",new Ingredient("GRBF","Ground Beef",IngType.Proteins));
	nameMapper.put("JACK",new Ingredient("JACK","Monterrey Jack",IngType.Cheese));
	nameMapper.put("LETC",new Ingredient("LETC","Lettuce",IngType.Veggies));
	nameMapper.put("SLSA",new Ingredient("SLSA","Salsa",IngType.Sauce));
	nameMapper.put("SRCR",new Ingredient("SRCR","Sour Cream",IngType.Sauce));
	nameMapper.put("TMTO",new Ingredient("TMTO","Diced Tomatoes",IngType.Veggies));
	}
}
