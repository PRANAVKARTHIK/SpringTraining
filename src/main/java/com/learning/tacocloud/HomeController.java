package com.learning.tacocloud;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import net.minidev.json.JSONObject;

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
	
	@PostMapping("/genericmail")
	@ResponseBody
	public String mailTrigger(@RequestBody JSONObject inputJSON){
		
		return "completed";
	}
}
