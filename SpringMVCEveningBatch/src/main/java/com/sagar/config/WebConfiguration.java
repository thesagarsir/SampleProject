package com.sagar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.sagar")
public class WebConfiguration implements WebMvcConfigurer {

	
	@Bean
	public InternalResourceViewResolver getResolver(){
		
		InternalResourceViewResolver veiwResolver = new InternalResourceViewResolver();
		veiwResolver.setPrefix("/WEB-INF/pages/");
		veiwResolver.setSuffix(".jsp");
		
		return veiwResolver;
	}
	
	
}
