package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.service.profileService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("/api/profile")
@RestController
public class ProfileController {
    private final profileService service;
    private final ModelMapper mapper;
    @PostMapping("setprofile")
    public ResponseEntity<String> setProfile(@RequestPart(value = "perfil") MultipartFile perfil, @RequestParam String name )throws Exception {

        service.setProfile(Profile.builder().imagemPerfil(perfil.getBytes()).username(name).build());

        return ResponseEntity.ok().body("Perfil criado");
    }

}
