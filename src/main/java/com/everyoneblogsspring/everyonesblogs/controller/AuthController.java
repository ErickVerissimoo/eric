package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.service.AuthService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService service;
    private final ModelMapper mapper;
    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody @Valid UserDTO dto) {


        return service.cadastrar(dto)? ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado") : ResponseEntity.badRequest().body("Usuário já cadastrado");
    }
    @PostMapping("logout")
    @Authenticated
    public String logout(HttpServletRequest request, HttpServletResponse response ) {
       return service.logout(response, request)? "Deslogado": "Erro";

    }


    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody UserDTO dto, HttpServletRequest request, HttpServletResponse response) {
    return service.login(mapper.map(dto, User.class), response, request)?
        ResponseEntity.ok().body("Autenticado") :
     ResponseEntity.badRequest().body("Não autorizado");
}

}
