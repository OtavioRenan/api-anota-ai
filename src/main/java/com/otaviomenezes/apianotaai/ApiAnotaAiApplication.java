package com.otaviomenezes.apianotaai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiAnotaAiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiAnotaAiApplication.class, args);
	}
}