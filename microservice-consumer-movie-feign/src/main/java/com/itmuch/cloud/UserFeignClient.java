package com.itmuch.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmuch.cloud.entity.User;
//@FeignClient("要去访问的服务的VIP")
@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	//@GetMapping("/user/{id}")在这里用不；一定要在写占位符的名字@PathVariable(占位符名)
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public User postUser(@RequestBody User user); 
	
	@RequestMapping(value="/get-user",method=RequestMethod.GET,consumes="application/json")
	public User getUser(@RequestParam("id") Long id,@RequestParam("name") String name);
}
