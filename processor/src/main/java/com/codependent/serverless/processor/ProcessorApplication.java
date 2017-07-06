package com.codependent.serverless.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionScan;

@FunctionScan
@SpringBootApplication
public class ProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}
	
}
