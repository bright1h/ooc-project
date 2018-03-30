package com.mapringg.bab.configurations;

import com.mapringg.bab.models.User;
import com.mapringg.bab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author mapring
 */
@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

    private CustomerRepository customerRepository;

    @Autowired
    public WebSecurityConfiguration(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(Bcrypt());
    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
            User user = customerRepository.findByEmail(username);
            if (user != null) {
                return org.springframework.security.core.userdetails.User
                        .withUsername(user.getEmail())
                        .password(user.getPassword())
                        .roles(user.getUserType().toString())
                        .build();
            } else {
                throw new UsernameNotFoundException("Could not find the username: " + username);
            }
        };
    }

    @Bean
    public PasswordEncoder Bcrypt() {
        return new BCryptPasswordEncoder();
    }
}
