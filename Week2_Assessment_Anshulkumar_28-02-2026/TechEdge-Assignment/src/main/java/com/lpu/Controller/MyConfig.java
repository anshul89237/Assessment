package com.lpu.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ComponentScan(basePackages = "com.lpu")
@Configuration
public class MyConfig {
	
	@Bean
	public EntityManagerFactory entityManagerFactory()
	{
		return Persistence.createEntityManagerFactory("dev");
	}
}
