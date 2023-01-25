package com.example.tin_projekt.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private int enabled;
}
