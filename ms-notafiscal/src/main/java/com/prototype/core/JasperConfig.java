package com.prototype.core;

import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

@Configuration
public class JasperConfig {

	@Bean
	JasperReport jasperReport() throws Exception {
		InputStream in = getClass().getResourceAsStream("");
		return JasperCompileManager.compileReport(in);
	}
}
