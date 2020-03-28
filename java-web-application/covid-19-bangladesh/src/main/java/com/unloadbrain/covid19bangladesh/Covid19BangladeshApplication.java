package com.unloadbrain.covid19bangladesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Covid19BangladeshApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19BangladeshApplication.class, args);
	}

}
