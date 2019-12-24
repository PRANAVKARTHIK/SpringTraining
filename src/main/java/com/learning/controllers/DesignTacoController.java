package com.learning.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.dto.TacoDTO;
import com.learning.entities.Ingredient;
import com.learning.entities.Taco;
import com.learning.entities.Ingredient.IngType;
import com.learning.repositories.IngredientRepository;
import com.learning.repositories.TacoRepository;
import com.learning.utilityclasses.ConstantInterface;
import com.learning.utilityclasses.ValidResponse;

import java.lang.reflect.Type;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	final Logger log =
		    LoggerFactory.getLogger(DesignTacoController.class);
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	TacoRepository tr;
	
	ModelMapper modelmapper;
	
	ValidResponse validResponse=new ValidResponse();
	
	
	@GetMapping
	public String showDesignForm(Model model) {

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients=ir.findAll();


		IngType[] types = Ingredient.IngType.values();
		for (IngType type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("design", new Taco());

		return "designTaco";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, IngType type) {
		List<Ingredient> typeList;
		typeList=ingredients.stream().filter(ingredient->ingredient.getType()==type).collect(Collectors.toList());
		return typeList;
	}

	@PostMapping
	public String processDesign(Taco taco){
		tr.save(taco);
		log.info("Processed Taco");
		return "redirect:/orders/current";	
	}
	
	@PostMapping("/listall")
	@ResponseBody
	public ValidResponse getAllDesignsList() {
		log.info("All designs listed");
		
		List<Taco> tacoEntList=tr.findAll();
//		Type type= new TypeToken<List<TacoDTO>>(){}.getType();
//		modelmapper.createTypeMap(Taco.class, TacoDTO.class);
//		List<TacoDTO> tacoList=modelmapper.map(tacoEntList, type);
		List<TacoDTO> tacoList=TacoDTO.getDtoFromEntity(tacoEntList);
		validResponse.setStatus(ConstantInterface.SuccessString);
		validResponse.setMessage("Completed listing all taco and its ingredients");
		validResponse.setData(tacoList);
		return validResponse;
	}
}
