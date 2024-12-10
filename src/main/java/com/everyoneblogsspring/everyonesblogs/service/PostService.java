package com.everyoneblogsspring.everyonesblogs.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.repository.postRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class PostService {
private final postRepository repository;


public List<Post> getAllPosts(){
    return repository.findAll();
}
public Post findOne(UUID uuid){
return repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Post não existe"));
}
public void postar(Post post) {
    repository.saveAndFlush(post);
}

}
