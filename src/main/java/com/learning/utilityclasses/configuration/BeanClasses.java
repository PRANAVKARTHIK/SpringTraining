package com.learning.utilityclasses.configuration;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.entities.Ingredient;
import com.learning.entities.Ingredient.IngType;
import com.learning.utilityclasses.dateutilities.DateUtil;
import com.learning.utilityclasses.dateutilities.TimestampUtil;

@Configuration
public class BeanClasses {
	@Bean
	public DateUtil dateUtil(){
		return new DateUtil();
	}
	
	@Bean 
	public TimestampUtil timeStampUtil(){
		return new TimestampUtil();
	}

}
