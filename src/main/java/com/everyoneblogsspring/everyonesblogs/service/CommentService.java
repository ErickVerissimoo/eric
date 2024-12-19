package com.everyoneblogsspring.everyonesblogs.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.everyoneblogsspring.everyonesblogs.model.Comment;
import com.everyoneblogsspring.everyonesblogs.repository.commentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
private final commentRepository repository;

public void comentar( Comment entity) {
    if(Objects.nonNull(entity))
    repository.saveAndFlush(entity);


}
public void deletarComment(UUID id){
if (repository.existsById(id)) {
    repository.deleteById(id);
}
}
public void update(Comment entity) {
    if (repository.existsById(entity.getId())) {
repository.saveAndFlush(entity);
    }
    
}

}
