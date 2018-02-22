package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.mapper.UserMapper;

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return userMapper.fetchUserById(id);
	}

}