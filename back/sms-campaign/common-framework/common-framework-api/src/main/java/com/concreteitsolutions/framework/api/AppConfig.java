package com.concreteitsolutions.framework.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.MultipartConfigElement;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.concreteitsolutions" })
public class AppConfig {

    /*
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("", -1L, -1L, 12344);
    } */
}
