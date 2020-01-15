package com.learning.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.dto.OrderDTO;
import com.learning.dto.TacoDTO;
import com.learning.entities.Order;
import com.learning.repositories.OrderRepository;
import com.learning.utilityclasses.ConstantInterface;
import com.learning.utilityclasses.ValidResponse;



@RestController
@RequestMapping(path="/orders")
public class OrderTacoController {
	
	OrderRepository or;
	
	public OrderTacoController(OrderRepository or) {
		super();
		this.or = or;
	}
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
	
	@PostMapping("/orders_dto")
	public ValidResponse processOrderDTO(@RequestBody JSONObject orderJson){
		OrderDTO orderDTO= new OrderDTO();
		ObjectMapper mapper=new ObjectMapper();
		try {
			orderDTO=mapper.readValue(orderJson.toJSONString(), OrderDTO.class);
		Order order=OrderDTO.getEntityFromDTO(orderDTO);
		or.save(order);
		return new ValidResponse(ConstantInterface.SuccessString,null,"Completed order successfully");
		} catch (IOException e) {
			return new ValidResponse(ConstantInterface.ErrorString,null,"failed to complete order");
		}
	}
	
	@GetMapping("/{username}")
	@ResponseBody
	public String getUserOrderCount(@PathVariable("username") String name ) {
		
		return Integer.toString(or.getCountOfCustomer(name));
	}
	
}
