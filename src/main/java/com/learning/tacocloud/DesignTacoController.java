package com.learning.tacocloud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.repositories.IngredientRepository;
import com.learning.repositories.TacoRepository;
import com.learning.tacocloud.Ingredient.Type;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	final Logger log =
		    LoggerFactory.getLogger(DesignTacoController.class);
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	TacoRepository tr;
	
	
	@GetMapping
	public String showDesignForm(Model model) {

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients=(List<Ingredient>) ir.findAll();


		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("design", new Taco());

		return "designTaco";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> typeList;
		typeList=ingredients.stream().filter(ingredient->ingredient.getType()==type).collect(Collectors.toList());
		return typeList;
	}

	@PostMapping
	public String processDesign(Taco taco){
		taco.createdAt();
		tr.save(taco);
		log.info("Processed Taco");
		return "redirect:/orders/current";	
	}
	
}
