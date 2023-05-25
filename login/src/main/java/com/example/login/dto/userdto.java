package com.example.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class userdto {
    /* we use userdto to transfer the data between
    the controller layer and the view layer. We also
    use userdto class for form binding
     */
    private Long id;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty(message="Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "password should not be empty")
    private String password;
}
