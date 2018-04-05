package com.mapringg.bab.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebCrossOriginConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/user/**").allowedOrigins("http://localhost:8080");
                registry.addMapping("/api/**").allowedOrigins("http://localhost:8080")
                        .allowedMethods("POST", "GET", "PUT", "DELETE");
            }
        };
    }
}
