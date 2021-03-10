package com.raj.imdbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ImdbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdbDemoApplication.class, args);
	}

}
