package com.learning.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.learning.entities.Ingredient.IngType;
import com.learning.entities.Taco;
import com.learning.repositories.IngredientRepository;
import com.learning.repositories.TacoRepository;
import com.learning.utilityclasses.ConstantInterface;
import com.learning.utilityclasses.ValidResponse;

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	final Logger log =
		    LoggerFactory.getLogger(DesignTacoController.class);
	
	@Autowired
	IngredientRepository ir;
	
	@Autowired
	TacoRepository tr;
	
	ModelMapper modelmapper= new ModelMapper();
	
	ValidResponse validResponse=new ValidResponse();
	
	
	@GetMapping
	public String showDesignForm(Model model) {

		List<Ingredient> ingredients;
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
		List<TacoDTO> tacoList=TacoDTO.getDtoFromEntity(tacoEntList);
		validResponse.setStatus(ConstantInterface.SuccessString);
		validResponse.setMessage("Completed listing all taco and its ingredients");
		validResponse.setData(tacoList);
		return validResponse;
	}
	
	@PostMapping("/listall_mm")
	@ResponseBody
	public ValidResponse getAllDesignsListModMap() {
		log.info("All designs listed");
		
		List<Taco> tacoEntList=tr.findAll();
		List<TacoDTO> finalList=tacoEntList.parallelStream().map(t->modelmapper.map(t, TacoDTO.class)).collect(Collectors.toList());
		validResponse.setStatus(ConstantInterface.SuccessString);
		validResponse.setMessage("Completed listing all taco and its ingredients");
		validResponse.setData(finalList);
		return validResponse;
	}
	@GetMapping("/mergecheck_modmap")
	@ResponseBody
	public String checkModMap(){
		return "check merger from ModMap";
	}
	
	@GetMapping("/mergecheck")
	@ResponseBody
	public String checkMerger(){
		return "check merger from MergeChecker";
	}
}
