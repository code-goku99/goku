package com.clinic.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.clinic.mongo.*","com.clinic.*"})
public class ClinicMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicMongoApplication.class, args);
	}

}
