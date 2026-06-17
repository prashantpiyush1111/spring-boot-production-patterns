package com.example.retry_logic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class RetryLogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetryLogicApplication.class, args);
	}

}