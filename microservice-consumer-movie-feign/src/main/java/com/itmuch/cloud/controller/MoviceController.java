package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.UserFeignClient;
import com.itmuch.cloud.entity.User;

@RestController
public class MoviceController {
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User fetchUserById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}
	@GetMapping("/test")
	public User testPost(User user) {
		return this.userFeignClient.postUser(user);
	}
	
	@GetMapping("/get-user")
	public User testGet(User user) {
		User user2 = this.userFeignClient.getUser(user.getId(),user.getName());
		return user2;
	}
}
