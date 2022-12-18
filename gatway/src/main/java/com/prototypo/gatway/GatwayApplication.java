package com.prototypo.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class GatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayApplication.class, args);
	}
	
	@Bean
	RouteLocator routers(RouteLocatorBuilder builder) {
		return builder
		       .routes()
		      //configurando as urls para os loand balance e o serviço específico da url
		      .route(r -> r.path("/usuarios/**").uri("lb://msusuarios")) // <url de acesso > e nome dado no application.yml do serviço
		      .route(r -> r.path("/teste/**").uri("lb://ms-usuarios"))
		    .build();
	}
}