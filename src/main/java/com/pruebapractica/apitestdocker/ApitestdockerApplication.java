package com.pruebapractica.apitestdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EnableAutoConfiguration
@SpringBootApplication
public class ApitestdockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApitestdockerApplication.class, args);
	}

}
