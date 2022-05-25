package com.terabulk.seller.config;

import com.mongodb.MongoClientOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*").allowCredentials(true);
    }
    
    @Bean
    public MongoClientOptions mongoOptions() {
         return MongoClientOptions.builder().maxConnectionIdleTime(600000).build();
    }
    
}