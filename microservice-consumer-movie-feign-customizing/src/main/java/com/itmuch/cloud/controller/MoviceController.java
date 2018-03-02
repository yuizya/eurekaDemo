package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.FeigntClient2;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MoviceController {
	@Autowired
	private UserFeignClient userFeignClient;
	@Autowired
	private FeigntClient2 client2;
	@GetMapping("/movie/{id}")
	public User fetchUserById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}
	
	@GetMapping("/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
		return this.client2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
	
}
