package com.itmuch.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.mapper.UserMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private UserMapper userMapper;
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id) {
		return userMapper.fetchUserById(id);
	}
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		/**
		 * getNextServerFromEureka(virtualHostname,secure)（虚拟host名称，默认是注册在Eureka的Application的名称）
		 * 作用：可以获取当前的ip地址和端口号：http://192.168.37.1:8080/
		 */
	    InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
	@GetMapping("/eureka-instance2")
	public String serviceUrl2() {
	    List<ServiceInstance> list = discoveryClient.getInstances("MICROSERVICE-PROVIDER-USER");
	    if (list != null && list.size() > 0 ) {
	    	//作用：可以获取当前的ip地址和端口号：http://192.168.37.1:8080/（和上面的方法作用一致）
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {
		/**
		 * 可以获取：{"host":"192.168.37.1","port":8080,"metadata":{},"secure":false,"uri":"http://192.168.37.1:8080",
		 * 			  "serviceId":"microservice-provider-user"}
		 */
		ServiceInstance instance = this.discoveryClient.getLocalServiceInstance();
		return instance;
	}
	
}
