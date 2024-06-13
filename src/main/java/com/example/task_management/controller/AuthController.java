package com.example.task_management.controller;

import com.example.task_management.dao.dto.RegisterDTO;
import com.example.task_management.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO registerDTO) {
        String token = authService.register(registerDTO);
        return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
    }
}


