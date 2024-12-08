package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.userDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController()
@RequestMapping(path = "/api/auth")
public class AuthController {
    private final AuthService service;
    public AuthController(AuthService service){
        this.service=service;
    }
    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody @Valid userDTO dto) {

        
        return service.cadastrar(dto)? ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado") : ResponseEntity.badRequest().body("Usuário já cadastrado");
    }
    

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody userDTO dto, HttpServletRequest request, HttpServletResponse response) {
    return service.login(dto.toEntity(User.class), response, request)?
        ResponseEntity.ok().body("Autenticado") :
     ResponseEntity.badRequest().body("Não autorizado");
}

}
