package com.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
//@EnableDiscoveryClient
public class MedsolConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedsolConfigServerApplication.class, args);
	}

}
