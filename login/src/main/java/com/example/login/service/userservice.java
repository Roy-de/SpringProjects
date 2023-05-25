package com.example.login.service;

import com.example.login.dto.userdto;
import com.example.login.entity.user;
import java.util.List;

public interface userservice {
    void saveuser(userdto userDto);

    user findByEmail(String email);

    List<userdto> findAllUsers();
}
