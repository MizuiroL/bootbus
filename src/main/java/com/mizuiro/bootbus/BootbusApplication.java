package com.mizuiro.bootbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BootbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootbusApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/stop").allowedOrigins("localhost:80");
				registry.addMapping("/api/v1/stop").allowedOrigins("localhost:443");
				registry.addMapping("/api/v1/stop").allowedOrigins("*");
			}
		};
	}

}
