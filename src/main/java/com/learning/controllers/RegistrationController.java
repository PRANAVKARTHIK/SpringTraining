package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.repositories.UserRepository;
import com.learning.utilityclasses.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEnc;

	public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEnc) {
		super();
		this.userRepository = userRepository;
		this.passwordEnc = passwordEnc;
	}

	@GetMapping
	public String registerForm(){
		return "RegistrationForm";
	}
	
	@PostMapping
	  public String processRegistration(RegistrationForm form) {
	    userRepository.save(form.toUser(passwordEnc));
	    return "redirect:/login";
	  }
	
	
}
