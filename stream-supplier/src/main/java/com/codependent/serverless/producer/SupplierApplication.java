package com.codependent.serverless.producer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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
	public Supplier<Flux<Map<String, Object>>> getValue(){
		return () -> {
			return Flux.interval(Duration.ofSeconds(1)).map( i -> {
				Map<String,Object> event = new HashMap<>();
				event.put("name", "RandomNumberGenerated");
				event.put("value",Math.random());
				return event;
				})
				.doOnNext( val -> logger.info("*** Producing {} ***", val));
		};
	}
}
