package com.example.security.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User",schema = "public")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}
