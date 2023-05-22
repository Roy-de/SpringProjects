package com.example.login.repository;

import com.example.login.entity.role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<role,Long> {

    /*
This code defines a Spring Data JPA repository interface called UserRepository
that extends the JPA repository interface. The JPA repository provides several
methods for performing CRUD operations on a JPA entity, and it takes two type
parameters: entity type and entity's primary key
* */
    role findBtName(String name);
}
