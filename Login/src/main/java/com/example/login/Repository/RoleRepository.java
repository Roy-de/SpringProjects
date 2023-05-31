package com.example.login.Repository;

import com.example.login.Model.ERole;
import com.example.login.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository {
    Optional<Role> findByName(ERole name);
}
