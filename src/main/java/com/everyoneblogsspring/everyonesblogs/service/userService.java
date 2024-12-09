package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.repository.userRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class userService {
private final userRepository repository;



}
