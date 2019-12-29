package com.learning.controllers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.TacoDTO;
import com.learning.entities.Taco;
import com.learning.repositories.TacoRepository;
import com.learning.utilityclasses.ConstantInterface;

@RestController
@RequestMapping(path="/design",produces=ConstantInterface.JSONString)
public class DesignTacoRESTController {

	TacoRepository tr;
	
	ModelMapper modelMapper=new ModelMapper();
	
	public DesignTacoRESTController(TacoRepository tr) {
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
	
	@PostMapping(consumes=ConstantInterface.JSONString)
	public Taco postTaco(@RequestBody TacoDTO tacoDTO){
//		Taco taco=modelMapper.map(tacoDTO, Taco.class);
		Taco taco=TacoDTO.getEntityFromDTO(tacoDTO);
		return tr.save(taco);
	}
}
