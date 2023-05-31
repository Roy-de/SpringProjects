package com.example.actuators;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class UserEntity {
 String id = "1";
 String name = "Roy Murithi";
 String Username = "Roy-de";
 String email = "roymuri28@gmail.com";
 String pincode = "453289";
}
