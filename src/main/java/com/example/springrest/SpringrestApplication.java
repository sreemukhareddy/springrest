package com.example.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringrestApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		System.out.println("Hello...First Commit");
		SpringApplication.run(SpringrestApplication.class, args);
	}

}
