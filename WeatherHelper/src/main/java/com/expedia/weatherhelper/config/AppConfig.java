package com.expedia.weatherhelper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.expedia.weatherhelper.helper.Helper;

@Configuration
public class AppConfig {
	
	@Bean
	public Helper helper(){
		return new Helper();
	}

}
