package com.creativity.registrymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class RegistryMicroserviceApplication {

	public static void main(String[] args) {
		lanzar();
		SpringApplication.run(RegistryMicroserviceApplication.class, args);
	}

	private static void lanzar(){
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println("PASSWORD CONVERTER");
		System.out.println(pe.encode("user"));
	}

}
