package com.sanchez.infraccionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DadEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(DadEx2Application.class, args);
	}

}
