package com.wintergames.game1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Game1App {

	private static final Logger logger = LoggerFactory.getLogger(Game1App.class);

	public static void main(String[] args) {
		SpringApplication.run(Game1App.class, args);
		logger.info("Running App");
	}

}
