package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieRibbonApplication {
	@Bean
	@LoadBalanced//整合了Ribbon，让RestTemplate具有Ribbon负载均衡的能力
	public RestTemplate restTemplate() { 
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonApplication.class, args);
	} 
}
