package com.directkart.epizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.directkart.epizza")
public class EpizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpizzaApplication.class, args);
	}

}
