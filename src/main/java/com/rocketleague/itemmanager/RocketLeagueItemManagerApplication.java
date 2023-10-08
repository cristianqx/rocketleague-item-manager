package com.rocketleague.itemmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = "com.rocketleague.itemmanager.entity")
//@EnableJpaRepositories(basePackages = "com.rocketleague.itemmanager.repository")
public class RocketLeagueItemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketLeagueItemManagerApplication.class, args);
	}

}
