package com.bluechip.goodmorning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GoodMorningApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodMorningApplication.class, args);
	}

}
