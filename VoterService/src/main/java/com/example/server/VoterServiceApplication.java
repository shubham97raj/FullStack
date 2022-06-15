package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoterServiceApplication.class, args);
		System.out.println("VoterService Application started");
	}

}
