package com.example.login.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Bean
    public static PasswordEncoder passwordEncoder(){
       return new Argon2PasswordEncoder(100,100,4,32,40);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authorizeHttpRequests((requests)->requests.
                        requestMatchers("/registration/**")
                        .permitAll().
                        requestMatchers("/login/**")
                        .permitAll().
                        requestMatchers("/user/**")
                        .hasAnyRole("USER")
                        .requestMatchers("/admin/**")
                        .hasAnyRole("ADMIN").anyRequest().authenticated())
                .formLogin((form)->form.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/user/").permitAll())
                .logout(LogoutConfigurer::permitAll).exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
}
