package com.spring.system.task_managment_system.controller;

import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.dto.TokenDto;
import com.spring.system.task_managment_system.service.auth.AuthService;
import com.spring.system.task_managment_system.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    ResponseEntity<TokenDto> login(@RequestBody LoginDto clientDto) throws RuntimeException {
        return ResponseEntity.ok(authService.login(clientDto));
    }

    @PostMapping("/create-account")
    ResponseEntity<TokenDto> createAccount(@RequestBody PersonDto newDto) throws RuntimeException {
        return ResponseEntity.ok(authService.createAccount(newDto));
    }
}
