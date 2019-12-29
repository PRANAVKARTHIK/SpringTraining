package com.learning.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Taco;
import com.learning.repositories.TacoRepository;

@RestController
@RequestMapping(path="/design",produces="application/json")
public class DesignTacoRESTController {

	TacoRepository tr;
	
	public DesignTacoRESTController(TacoRepository tr) {
		super();
		this.tr = tr;
	}

	@GetMapping("/{name}")
	public ResponseEntity<Taco> getRecentTacoDesigns(@PathVariable("name") String name){
		Optional<Taco> taco=tr.findByName(name);
		if(taco.isPresent()){
			return new ResponseEntity<Taco>(taco.get(),HttpStatus.OK);
		}else{
			return new ResponseEntity<Taco>(taco.get(),HttpStatus.NOT_FOUND);
		}
	}
	
}
