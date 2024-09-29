package com.capstone.model;


import com.capstone.config.Constant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;


    private String email;


    private String password;

    private String phone;
    private String address;

    private BigDecimal balance = Constant.USER_BALANCE;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

