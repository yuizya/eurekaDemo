package com.itmuch.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * 把这一个类放在MovieRibbonApplication扫描不到的地方，否则会被全部@RibbonClients共享
 * @author Administrator
 *
 */
@Configuration
@ExcludeFromComponentScan
public class TestConfiguration {
	/*@Autowired
	IClientConfig config;*/
	/**
	 * Ribbon 随机负载均衡算法
	 * Ribbon默然的负载均衡算法是轮询，但是可以通过ribbonRule指定负载均衡的算法
	 * @param config
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
