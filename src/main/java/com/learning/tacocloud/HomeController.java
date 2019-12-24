package com.learning.tacocloud;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
}
