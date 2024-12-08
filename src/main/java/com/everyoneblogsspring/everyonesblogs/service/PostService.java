package com.everyoneblogsspring.everyonesblogs.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.repository.postRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostService {
private final postRepository repository;

public PostService(postRepository repository){
this.repository=repository;
}
public List<Post> getAllPosts(){
    return repository.findAll();
}
public Post findOne(UUID uuid){
return repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Post não existe"));
}
}
