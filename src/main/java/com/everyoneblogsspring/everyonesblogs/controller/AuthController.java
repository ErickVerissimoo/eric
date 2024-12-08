package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.userDTO;
import com.everyoneblogsspring.everyonesblogs.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service){
        this.service=service;
    }
    @PostMapping("login")
public ResponseEntity<String> login(@RequestBody userDTO dto, HttpServletRequest request, HttpServletResponse response) {
    if (service.login(dto, response, request)){
        return ResponseEntity.ok().body("Autenticado");
    }
    
    return ResponseEntity.badRequest().body("Não autorizado");
}

}
