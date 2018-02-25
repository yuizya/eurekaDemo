package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MoviceController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@GetMapping("/movie/{id}")
	public User fetchUserById(@PathVariable Long id) {
		/**
		 * 一开始使用http://localhost:8080/user/
		 * microservice-provider-user：是VIP——virtual ip（虚拟ip）
		 * */
		return restTemplate.getForObject("http://microservice-provider-user/user/"+id,User.class);
	}
	
	@GetMapping("/test")
	public String test() {
		//choose("microservice-provider-user");——指的是我要选择哪一个微服务
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("111："+serviceInstance.getHost()+":"+serviceInstance.getPort()+":"+serviceInstance.getServiceId());
		
		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("222："+serviceInstance2.getHost()+":"+serviceInstance2.getPort()+":"+serviceInstance2.getServiceId());
		return "i";
	}
}
