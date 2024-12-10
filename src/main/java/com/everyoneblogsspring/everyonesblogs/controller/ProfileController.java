package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everyoneblogsspring.everyonesblogs.dto.ProfileDTO;
import com.everyoneblogsspring.everyonesblogs.service.profileService;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@RequestMapping("/api/profile")
@RestController
public class ProfileController {
    private final profileService service;
    private final UserMapper mapper;
    @PostMapping("setprofile")
    public ResponseEntity<String> setProfile(@ModelAttribute ProfileDTO dto ) {
        
        service.setProfile(mapper.toProfile(dto));
        
        return ResponseEntity.ok().body("Perfil criado");
    }
    
}
