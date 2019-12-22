package com.learning.tacocloud;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.tacocloud.Ingredient.Type;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	final Logger log =
		    LoggerFactory.getLogger(DesignTacoController.class);
	@GetMapping
	public String showDesignForm(Model model) {

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(new Ingredient("1", "Flour Tortilla", Type.Wrap));
		ingredients.add(new Ingredient("2", "Ground Beef", Type.Proteins));
		ingredients.add(new Ingredient("3", "Carnitas", Type.Proteins));
		ingredients.add(new Ingredient("4", "Diced Tomatoes", Type.Veggies));
		ingredients.add(new Ingredient("CHED", "Cheddar", Type.Cheese));
		ingredients.add(new Ingredient("JACK", "Monterrey Jack", Type.Cheese));
		ingredients.add(new Ingredient("SLSA", "Salsa", Type.Sause));
		ingredients.add(new Ingredient("SRCR", "Sour Cream", Type.Sause));


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
		log.info("Processed Taco");
		return "redirect:/orders/current";	
	}
	
}
