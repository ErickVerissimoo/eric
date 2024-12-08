package com.everyoneblogsspring.everyonesblogs.service;

import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.repository.userRepository;
@Service
public class userService {
private final userRepository repository;

public userService(userRepository repository){
this.repository=repository;
}

}
