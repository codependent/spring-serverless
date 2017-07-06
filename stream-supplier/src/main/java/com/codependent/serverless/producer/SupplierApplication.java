package com.codependent.serverless.producer;

import java.time.Duration;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SupplierApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SupplierApplication.class, args);
	}
	
	@Bean
	public Supplier<Flux<String>> getValue(){
		return () -> {
			return Flux.interval(Duration.ofSeconds(1)).map( i -> String.valueOf(Math.random()))
				.doOnNext( val -> logger.info("*** Producing {} ***", val));
		};
	}
}
