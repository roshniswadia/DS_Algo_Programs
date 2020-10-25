package com.springboot.microservice.example.apigateway.springbootmicroservicezuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootMicroserviceZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceZuulGatewayApplication.class, args);
	}

}
