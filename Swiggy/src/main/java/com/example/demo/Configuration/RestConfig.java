package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	RestTemplate resttemplate() {

		RestTemplate rt = new RestTemplate();
		return rt;

	}
}
