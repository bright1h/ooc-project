package com.mapringg.bab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mapring
 */

@SpringBootApplication
@EnableCaching
public class BabApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*/*").allowedOrigins("http://localhost:8080");
                registry.addMapping("/api/*").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
