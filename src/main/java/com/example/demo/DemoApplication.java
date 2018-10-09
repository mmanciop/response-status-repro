package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	public static class ApiController {

		@GetMapping("nope")
		public Mono<String> nope() {
			return Mono.error(new NopeException());
		}

		@GetMapping("yep")
		public Mono<String> yep() {
			return Mono.error(new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT));
		}

	}

	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	static class NopeException extends RuntimeException {
		NopeException() {
			super("Nope!");
		}
	}

}