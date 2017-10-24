package com.chrgue.poc.legacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LegacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegacyApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "hello";
	}
}
