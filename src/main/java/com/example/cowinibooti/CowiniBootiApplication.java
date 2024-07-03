package com.example.cowinibooti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.cowinibooti"})
public class CowiniBootiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowiniBootiApplication.class, args);
	}

}
