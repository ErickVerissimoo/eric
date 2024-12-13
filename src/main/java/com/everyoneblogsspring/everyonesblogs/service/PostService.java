package com.everyoneblogsspring.everyonesblogs.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.everyoneblogsspring.everyonesblogs.dto.PostDTO;
import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.repository.postRepository;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class PostService {
private final postRepository repository;
private final UserMapper mapper;

public List<Post> getAllPosts(){
    return repository.findAll();
}
public Post findOne(UUID uuid){
return repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Post não existe"));
}
public void postar(Post post) {
    repository.saveAndFlush(post);
}
public void deletar(UUID uuid){
repository.deleteById(uuid);
}
public void update(UUID id, PostDTO post) {
    var e = repository.findById(id).orElseThrow();
    e = mapper.toPost(null);
    repository.saveAndFlush(e);
}
}
