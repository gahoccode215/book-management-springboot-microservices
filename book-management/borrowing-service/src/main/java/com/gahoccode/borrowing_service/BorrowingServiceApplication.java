package com.gahoccode.borrowing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.gahoccode.borrowing_service", "com.gahoccode.common_service"})
public class BorrowingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowingServiceApplication.class, args);
	}

}
