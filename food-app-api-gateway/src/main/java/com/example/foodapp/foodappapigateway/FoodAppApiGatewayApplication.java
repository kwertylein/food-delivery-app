package com.example.foodapp.foodappapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodAppApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApiGatewayApplication.class, args);
	}

}
