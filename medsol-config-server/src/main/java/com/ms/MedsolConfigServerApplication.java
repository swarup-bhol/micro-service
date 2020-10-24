package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MedsolConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedsolConfigServerApplication.class, args);
	}

}
