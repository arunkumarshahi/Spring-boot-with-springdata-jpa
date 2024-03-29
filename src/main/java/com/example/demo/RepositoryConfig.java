package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RepositoryConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/dogs/**").allowedOrigins("http://localhost:3000").allowedMethods("*").allowedHeaders("*")
				.allowCredentials(false).maxAge(3600);
	}

}
