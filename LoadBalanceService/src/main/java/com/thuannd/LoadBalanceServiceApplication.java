package com.thuannd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoadBalanceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalanceServiceApplication.class, args);
	}

}
