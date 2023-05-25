package com.example.login.controller;

import com.example.login.dto.userdto;
import com.example.login.entity.user;
import com.example.login.service.userservice;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Controller;
import  org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class authcontroller {
    //Handler method to save user registration data to postgres
    private userservice UserService;
    public authcontroller(userservice UserService){
        this.UserService = UserService;
    }

    //Handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    //Handler for handling user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        //Create model object to store form data
        userdto user = new userdto();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping("/register/save")

    public String registration(@Valid @ModelAttribute("user") userdto UserDto,
                                                            BindingResult result,
                                                            Model model){
        user existingUser = userservice.findUserByEmail(UserDto.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
           result.rejectValue("email", String.valueOf(100),"There is an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user",UserDto);
            return "/register";
        }
        userservice.saveuser(UserDto);
        return "redirect:/register?success";
    }

    //handler to display list of users
    @GetMapping("/users")
    public String users(Model model){
        List<userdto> users = userservice.findAllUsers();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
/*This above code defines a Spring MVC controller class
called AuthController that handles incoming requests to the
/index URL path. The @Controller annotation indicates that this class
is a Spring MVC controller and should be scanned by the Spring framework
for handling incoming requests.*/


