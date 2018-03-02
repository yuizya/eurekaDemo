package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class Configuration1 {
	@Bean//Contract表示契约
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
	//选择打印日志的级别
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
} 
