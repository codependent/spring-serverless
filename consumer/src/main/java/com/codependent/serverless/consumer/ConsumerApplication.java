package com.codependent.serverless.consumer;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	
	@Bean
	public Consumer<String> registerEvent(){
		return (String event) -> {
			System.out.println(event);
			//TODO send to transformer;
		};
	}
	
}
