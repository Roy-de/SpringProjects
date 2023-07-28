package com.example.security2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth)->auth
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/admin").hasAnyRole("USER","ROLE")
                .anyRequest().permitAll());
        return http.build();
    }
    @Bean
    public UserDetailsService user(){
        UserDetails userDetails = User.withUsername("roy")
                        .password("password")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
