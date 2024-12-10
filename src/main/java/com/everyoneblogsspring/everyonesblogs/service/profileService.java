package com.everyoneblogsspring.everyonesblogs.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.model.User;
import com.everyoneblogsspring.everyonesblogs.repository.profileRepository;
import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class profileService {
private final profileRepository repository;

public void setProfile(Profile profile) {
    
    
    repository.saveAndFlush(profile);


}}
