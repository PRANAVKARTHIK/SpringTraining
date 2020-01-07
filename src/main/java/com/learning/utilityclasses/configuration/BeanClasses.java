package com.learning.utilityclasses.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
