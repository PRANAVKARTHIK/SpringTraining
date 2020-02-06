package com.learning.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Ingredient.IngType;
import com.learning.dto.TacoUserDTO;
import com.learning.entities.TacoUser;
import com.learning.repositories.TacoUserRepository;
import com.learning.utilityclasses.ConstantInterface;
import com.learning.utilityclasses.ValidResponse;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/home",produces=ConstantInterface.JSONString)
public class HomeController {
	
	@Autowired
	TacoUserRepository tur;

	@GetMapping("/")
	@ResponseBody
	public ArrayList<String> home(){
		
		ArrayList<String> str= new ArrayList<>();
		str.add("pk");
		str.add("paraak");
		return str;
	}
	
	
	@GetMapping("/ingredient")
	@ResponseBody
	public IngType[] IngredientTypes(){
		return IngType.values();
	}
	
	@PostMapping("/login")
	public ValidResponse customerLogin(@RequestBody TacoUserDTO user) {
		ValidResponse vr=new ValidResponse();
		Object[] checkUser = null;
		try {
			checkUser = tur.getUserDetails(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (checkUser != null) {
			vr=new ValidResponse(ConstantInterface.SuccessString, checkUser, null);
		} else {
			vr=new ValidResponse(ConstantInterface.ErrorString, null, null);
		}
		return vr;
	}
	
}
