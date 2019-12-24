package com.learning.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.entities.Order;
import com.learning.repositories.OrderRepository;

@Controller
@RequestMapping("/orders")
public class OrderTacoController {
	
	@Autowired
	OrderRepository or;

	Logger log=LoggerFactory.getLogger(OrderTacoController.class);
	
	@GetMapping("/current")
	public String orderTaco(Model model){
		model.addAttribute("order",new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processTaco(Order order){

		or.save(order);
		log.info("Processed order:{}",order);
		return "redirect:/design";
	}
	
	@GetMapping("/{username}")
	@ResponseBody
	public String getUserOrderCount(@PathVariable("username") String name ) {
		
		return Integer.toString(or.getCountOfCustomer(name));
	}
	
}
