package com.concreteitsolutions.sms;

import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.concreteitsolutions.sms")
public class ISendProClientConfiguration {

	@Bean
	RestTemplate iSendProInterface() throws URISyntaxException {
		RestTemplate client = new RestTemplate();

		return client;
	}
}
