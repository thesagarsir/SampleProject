package com.sagar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sagar.entity.Login;

@Configuration
@EnableWebMvc
public class HibernateConfiguration {

	@Autowired
	ApplicationContext context;
	
	@Bean
	public LocalSessionFactoryBean getBean() {
		System.out.println("I am in Hibernate Configuration..!!!");
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(Login.class);
		return factoryBean;
	}
}
