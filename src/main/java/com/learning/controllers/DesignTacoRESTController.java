package com.learning.controllers;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.learning.dto.IngredientDTO;
import com.learning.dto.TacoDTO;
import com.learning.entities.Ingredient;
import com.learning.entities.Taco;
import com.learning.repositories.TacoRepository;
import com.learning.utilityclasses.ConstantInterface;

@RestController
@RequestMapping(path="/design",produces=ConstantInterface.JSONString)
public class DesignTacoRESTController {

	TacoRepository tr;
	
	ModelMapper modelMapper;
	
	public DesignTacoRESTController(TacoRepository tr) {
		this.tr = tr;
	}

	@GetMapping("/{name}")
	public ResponseEntity<Taco> getRecentTacoDesigns(@PathVariable("name") String name){
		Optional<Taco> taco=tr.findByName(name);
		if(taco.isPresent()){
			return new ResponseEntity<>(taco.get(),HttpStatus.OK);
		}else{
			return new ResponseEntity<>(taco.get(),HttpStatus.NOT_FOUND);
		}
	}

	/* 
	 * entity input directly given
	 * */ 
	@PostMapping(path="/tacoEntSave",consumes=ConstantInterface.JSONString)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void postTacoDTO(@RequestBody Taco taco){
		tr.save(taco);
	}
	
	
	/*
	 ********* Sample testing code
	 * */
	@PostMapping(value="/ndto",consumes=ConstantInterface.JSONString)
	public void postTaco(@RequestBody JSONObject taco){
		TacoDTO tacoDTO=new TacoDTO();
		tacoDTO.setName((String)taco.get("name"));
		tacoDTO.setIngredients((List<IngredientDTO>)taco.get("ingredients"));
		Taco tacoObject=TacoDTO.getEntityFromDTO(tacoDTO);
		tr.save(tacoObject);
	}
	
	@PostMapping(value="/tacosave")
	public void saveTaco(@RequestBody JSONObject inputJson) {
		Taco tacoEntity=new Taco();
//		JSONObject taco=new JSONObject(inputJson);
		String name=String.valueOf(inputJson.get("name"));
//		JSONArray ingArray=(JSONArray) taco.get("ingredients");
//		List<Ingredient> ingredientList=new ArrayList<Ingredient>();
//		for(Object i:ingArray) {
//			ingredientList.add((Ingredient)i);
//		}
		tacoEntity.setName(name);
		List<Ingredient> ingredientList=(List<Ingredient>) inputJson.get("ingredients");
		
		tacoEntity.setIngredients(ingredientList);
		tr.save(tacoEntity);
	}
}
