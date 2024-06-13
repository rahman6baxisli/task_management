package com.example.task_management.dao.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}

