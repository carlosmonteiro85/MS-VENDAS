package com.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProdutoApplication.class, args);
	}

}
