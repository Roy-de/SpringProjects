package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"com.example.demo"})
public class AppConfig {
    @Bean
    @Scope("threadScope")
    public Volunteer getVolunteer(){
        Volunteer volunteer = new Volunteer();
        volunteer.setName("Roy Murithi");
        volunteer.setQualifications("Bsc Computer Science");
        volunteer.setAddress("Kericho");
        volunteer.setDob("30-11-01");
        return volunteer;
    }
}
