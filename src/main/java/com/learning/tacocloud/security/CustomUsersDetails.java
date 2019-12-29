package com.learning.tacocloud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.entities.User;
import com.learning.repositories.UserRepository;


@Service
public class CustomUsersDetails implements UserDetailsService {

	UserRepository userRepository;
	 
	@Autowired 
	CustomUsersDetails userDetailsService;
	
	public CustomUsersDetails(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.findUsername(username);
		if(user!=null){
			return user;
		}
		throw new UsernameNotFoundException(
                "User '" + username + "' not found");
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}
