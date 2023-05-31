package com.example.login.Security;

import com.example.login.Security.Service.UserDetailsServiceimpl;
import com.example.login.Security.jwt.AuthEntrypointJwt;
import com.example.login.Security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableMethodSecurity
/*(securedEnabled = true,
jsr250Enabled = true,
prepostEnabled = true
* */
public class WebSecurityConfig extends WebSecurityConfiguration {
    @Autowired
    UserDetailsServiceimpl userDetailsService;
    @Autowired
    private AuthEntrypointJwt unauthorizedHandler;
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter(){
        return new AuthTokenFilter();
    }
    @Override
    public void configure(@org.jetbrains.annotations.NotNull AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManager()throws Exception{
        return authenticationManager();
    }

}
