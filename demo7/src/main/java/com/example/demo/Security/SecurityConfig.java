package com.example.demo.Security;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration{
    @Override
    protected void configure(HttpSecurity http) throws
            Exception{
        http.authorizeHttpRequests().
                anyRequest().authenticated()
    }
}
