package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)//指定RibbonClient，microservice-provider-user有多个节点
//设置@ComponentScan不扫描有@ExcludeFromComponentScan的类，从而可以TestConfiguration不被共有
@ComponentScan(excludeFilters= {@ComponentScan.Filter(type=FilterType.ANNOTATION,value=ExcludeFromComponentScan.class) })
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
