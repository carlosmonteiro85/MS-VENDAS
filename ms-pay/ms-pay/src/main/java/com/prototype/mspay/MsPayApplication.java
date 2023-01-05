package com.prototype.mspay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
@EnableEurekaClient
@SpringBootApplication
public class MsPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPayApplication.class, args);
	}

}
