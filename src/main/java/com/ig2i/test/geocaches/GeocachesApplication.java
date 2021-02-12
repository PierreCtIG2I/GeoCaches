package com.ig2i.test.geocaches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableJpaRepositories(basePackages = "com.ig2i.test.geocaches.BDD.MySQL")
@EnableMongoRepositories(basePackages = "com.ig2i.test.geocaches.BDD.MongoDB")
@SpringBootApplication
public class GeocachesApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeocachesApplication.class, args);
	}
}
