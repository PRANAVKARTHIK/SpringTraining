package com.learning.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.entities.Ingredient.IngType;


@Controller
public class HomeController {

	@GetMapping("/")
	@ResponseBody
	public ArrayList<String> home(){
		
		ArrayList<String> str= new ArrayList<>();
		str.add("pk");
		str.add("paraak");
		return str;
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/ingredient")
	@ResponseBody
	public IngType[] IngredientTypes(){
		return IngType.values();
	}
}
