package com.codependent.serverless.consumer;

import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ConsumerApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	@Bean
	public Consumer<Flux<Map<String, Object>>> consume(){
		return (Flux<Map<String, Object>> consume) -> {
			consume.subscribe( (value) -> {
				logger.info("Got {}", value);
			});
		};
	}
	
}
