package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RestController
	static class HomeController {
		@RequestMapping(method = RequestMethod.GET)
		ResponseEntity<?> home () {
			return ResponseEntity.ok("hello wenzi and zhengzhong");
		}
	}
}
