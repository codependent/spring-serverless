package com.codependent.serverless.producer;

import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierApplication.class, args);
	}
	
	@Bean
	public Supplier<Flux<String>> getValue(){
		return () -> {
			return Flux.just(String.valueOf(Math.random()));
		};
	}
}
