package com.Training.trainingPortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TrainingPortalApplication implements CommandLineRunner
{
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TrainingPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
	     System.out.println(this.passwordEncoder.encode("xyz"));	
	}

}
