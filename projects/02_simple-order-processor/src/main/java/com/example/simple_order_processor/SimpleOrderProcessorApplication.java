package com.example.simple_order_processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleOrderProcessorApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleOrderProcessorApplication.class, args);
	}
}
