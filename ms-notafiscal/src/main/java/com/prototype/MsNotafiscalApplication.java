package com.prototype;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableRabbit
@SpringBootApplication
public class MsNotafiscalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNotafiscalApplication.class, args);
	}

}
