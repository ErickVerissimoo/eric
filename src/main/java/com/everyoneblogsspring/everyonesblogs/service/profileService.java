package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.stereotype.Service;
import com.everyoneblogsspring.everyonesblogs.model.Profile;
import com.everyoneblogsspring.everyonesblogs.repository.profileRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class profileService {
private final profileRepository repository;

public void setProfile(Profile profile) {
    
    
    repository.saveAndFlush(profile);


}}
