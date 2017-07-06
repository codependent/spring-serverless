package com.codependent.serverless.consumer;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	@Bean
	public Consumer<Flux<String>> registerEvent(){
		return (Flux<String> event) -> {
			System.out.println(event);
			//TODO send to transformer;
		};
	}
	
}
