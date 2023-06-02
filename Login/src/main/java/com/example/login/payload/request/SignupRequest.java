package com.example.login.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3,max = 20)
    private String username;
    @NotBlank
    @Size(min = 30)
    private String email;
    private Set<String> role;
    @NotBlank
    @Size(min=8,max = 20)
    private String password;
}
