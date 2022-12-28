package com.prototype.core.modelmapper;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("ms-produtos")
@org.springframework.context.annotation.Configuration
public class Configuration {
	
	@Getter
	@Setter
	private String value;
	
}
