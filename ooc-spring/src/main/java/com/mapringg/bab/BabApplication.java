package com.mapringg.bab;

import com.mapringg.bab.models.User;
import com.mapringg.bab.models.UserType;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
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
                registry.addMapping("/api/*/*").allowedOrigins("http://localhost:8080")
                        .allowedMethods("POST", "GET", "PUT", "DELETE");
                registry.addMapping("/api/*").allowedOrigins("http://localhost:8080")
                        .allowedMethods("POST", "GET", "PUT", "DELETE");
            }
        };
    }

    @Bean
    CommandLineRunner init(final CustomerRepository customerRepository) {

        return arg0 -> customerRepository.save(new User("Sorawit", "0955746161", "trainer.mapring@gmail.com", "Kongnurat", "1234", UserType.USER));

    }
}
