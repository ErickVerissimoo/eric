package com.everyoneblogsspring.everyonesblogs.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.profileRepository;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class profileService {
private final userRepository repository;

public void setImageProfile(MultipartFile file, User user) {
    try{
    user.getProfile().setImagemPerfil(file.getBytes());
    repository.saveAndFlush(user);
}catch(IOException exception){
exception.printStackTrace();
}
}
}
