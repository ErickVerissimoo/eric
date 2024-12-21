package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.UserDTO;
import com.everyoneblogsspring.everyonesblogs.exceptions.LoginFailedException;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.service.AuthService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
    @PostMapping("/logout")
    @Authenticated
    public String logout(HttpServletRequest request, HttpServletResponse response ) {
        


        return service.logout(response, request)? "Deslogado": "Erro";

    }


    @PostMapping("/login")
public EntityModel<User> login(@RequestBody UserDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception {
    if(!service.login(mapper.map(dto, User.class), response, request)){
        throw new LoginFailedException("Email ou senha incorretos ou usuário não cadastrado");
    }
    service.login(mapper.map(dto, User.class), response, request);
    EntityModel<User> user = EntityModel.of(mapper.map(dto, User.class));
    user.add(linkTo(    WebMvcLinkBuilder.methodOn( HomeController.class).getAll()).withSelfRel());

    return user;
}

}
