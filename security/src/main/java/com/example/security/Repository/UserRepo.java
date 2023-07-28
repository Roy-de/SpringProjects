package com.example.security.Repository;

import com.example.security.DTO.UserDto;
import com.example.security.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserDto findByUsername(String username);
}
