package com.itmuch.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.config.Configuration2;
//有url的时候。name只是起个名称；如果只有name那么name就是指VIP
@FeignClient(name="xxxx",url="http://localhost:8761/",configuration=Configuration2.class)
public interface FeigntClient2 {
	//因为这么没有设置Configuration1.class，所以是可以使用SpringMVC的注解的
	@RequestMapping(value="/eureka/apps/{serviceName}",method=RequestMethod.GET)
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
