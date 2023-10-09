package com.rocketleague.itemmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "com.rocketleague.itemmanager.entity")
//@EnableJpaRepositories(basePackages = "com.rocketleague.itemmanager.repository")
public class RocketLeagueItemManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketLeagueItemManagerApplication.class, args);
	}

}
