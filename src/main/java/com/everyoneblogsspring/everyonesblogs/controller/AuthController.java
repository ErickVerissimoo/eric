package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.service.AuthService;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;
    private final UserMapper mapper;
    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody @Valid UserDTO dto) {

        
        return service.cadastrar(dto)? ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado") : ResponseEntity.badRequest().body("Usuário já cadastrado");
    }
    

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody UserDTO dto, HttpServletRequest request, HttpServletResponse response) {
    return service.login(mapper.toUser(dto), response, request)?
        ResponseEntity.ok().body("Autenticado") :
     ResponseEntity.badRequest().body("Não autorizado");
}

}
