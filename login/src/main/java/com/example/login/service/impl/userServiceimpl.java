package com.example.login.service.impl;

import com.example.login.dto.userdto;
import com.example.login.entity.role;
import com.example.login.entity.user;
import com.example.login.repository.RoleRepository;
import com.example.login.repository.UserRepository;
import com.example.login.service.userservice;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class userServiceimpl implements userservice {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public userServiceimpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder){

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void saveuser(userdto userDto) {
        user User = new user();
        User.setEmail(userDto.getFirstname()+" " +userDto.getLastname());
        User.setEmail(userDto.getEmail());
        //Encrypt password using spring security
        User.setPassword(passwordEncoder.encode(userDto.getPassword()));

        role Role = roleRepository.findByName("ROLE_ADMIN");
        if(Role == null){
            Role = checkRoleExist();
        }
        User.setRoles(List.of(Role));
        UserRepository.save(User);
    }

    private role checkRoleExist() {
        role Role =  new role();
        Role.setName("ROLE_ADMIN");
        return roleRepository.save(Role);
    }

    @Override
    public user findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public List<userdto> findAllUsers() {

        List<user> Users = userRepository.findAll();
        return Users.stream()
                .map((User) -> mapToUserDto(User))
                .collect(Collectors.toList());
    }

    private userdto mapToUserDto(user User) {
        userdto UserDto = new userdto();
        String[] str = User.getName().split(" ");
        UserDto.setFirstname(str[0]);
        UserDto.setLastname(str[1]);
        UserDto.setEmail(User.getEmail());
        return UserDto;
    }
}
