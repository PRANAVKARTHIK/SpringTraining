package com.learning.utilityclasses;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.learning.entities.User;

public class RegistrationForm {

	String id;
	String fullname;
	String username;
	String password;

	public User toUser(PasswordEncoder passwordEncoder) {
		return new User(username, passwordEncoder.encode(password), fullname);
	}
}
