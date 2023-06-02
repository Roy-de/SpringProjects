package com.example.login.Security;

import com.example.login.Security.Service.UserDetailsServiceimpl;
import com.example.login.Security.jwt.AuthEntrypointJwt;
import com.example.login.Security.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
/*(securedEnabled = true,
jsr250Enabled = true,
prepostEnabled = true
* */
public class WebSecurityConfig {
    final
    UserDetailsServiceimpl userDetailsService;
    private final AuthEntrypointJwt unauthorizedEntry;

    public WebSecurityConfig(UserDetailsServiceimpl userDetailsService, AuthEntrypointJwt unauthorizedEntry) {
        this.userDetailsService = userDetailsService;
        this.unauthorizedEntry = unauthorizedEntry;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter(){
        return new AuthTokenFilter();
    }
   @Bean
   public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService((UserDetailsService) userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return  authProvider;
   }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authconfig)throws Exception{
        return authconfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.csrf(AbstractHttpConfigurer::disable).
                exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedEntry))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/test/**").permitAll()
                                .anyRequest().authenticated());
        return http.build();
    }

}
