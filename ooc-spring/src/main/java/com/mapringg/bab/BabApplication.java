package com.mapringg.bab;

import com.mapringg.bab.models.CustomerOrder;
import com.mapringg.bab.models.User;
import com.mapringg.bab.models.UserType;
import com.mapringg.bab.repositories.CustomerOrderRepository;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Calendar;
import java.sql.*;

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
                registry.addMapping("/api/*/*/*").allowedOrigins("http://localhost:8080");
                registry.addMapping("/api/*/*").allowedOrigins("http://localhost:8080");
                registry.addMapping("/api/*").allowedOrigins("http://localhost:8080");
            }
        };
    }

    @Bean
    CommandLineRunner init(final CustomerRepository customerRepository, CustomerOrderRepository customerOrderRepository) {

        return arg0 -> {
            customerRepository.save(new User("Sorawit", "trainer.mapring@gmail.com", "0955746161", "Kongnurat", "1234", UserType.USER));
//            customerOrderRepository.save(new CustomerOrder(null,null,"Preparing"));
        };

    }
}
