package com.learning.tacocloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderTacoController {

	Logger log=LoggerFactory.getLogger(OrderTacoController.class);
	
	@GetMapping("/current")
	public String orderTaco(Model model){
		model.addAttribute("order",new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processTaco(Order order){
		log.info("Processed order:"+ order.toString());
		return "redirect:/";
	}
	
}
