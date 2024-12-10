package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.everyoneblogsspring.everyonesblogs.dto.PostDTO;
import com.everyoneblogsspring.everyonesblogs.dto.ProfileDTO;
import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.repository.profileRepository;
import com.everyoneblogsspring.everyonesblogs.service.profileService;

import lombok.RequiredArgsConstructor;

import java.net.ResponseCache;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RequestMapping("/api/profile")
@RestController
public class ProfileController {
    private final profileService service;

    @PostMapping("setprofile")
    public ResponseEntity<String> setProfile(@ModelAttribute ProfileDTO dto ) {
        
        service.setProfile(dto.toEntity(Profile.class));
        
        return ResponseEntity.ok().body("Perfil criado");
    }
    
}
