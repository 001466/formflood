package com.ec.formflood;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.ec"})
@EnableDiscoveryClient
@EnableFeignClients
public class FormfloodApplication {
	
	private  static final Logger  LOGGER = LoggerFactory.getLogger(FormfloodApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FormfloodApplication.class, args);
	}
}
