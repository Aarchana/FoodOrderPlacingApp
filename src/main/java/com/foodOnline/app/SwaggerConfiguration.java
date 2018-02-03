package com.foodOnline.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	private static final Set<String> API_PRODUCES = new HashSet<String>(Arrays.asList("application/json"));

	@Bean
	public Docket apiDoc(){
		
		return new Docket(DocumentationType.SWAGGER_2).produces(API_PRODUCES);
		
	}
}
