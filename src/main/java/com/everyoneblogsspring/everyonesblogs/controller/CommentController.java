package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.CommentDTO;
import com.everyoneblogsspring.everyonesblogs.model.Comment;
import com.everyoneblogsspring.everyonesblogs.service.CommentService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/comment")

public class CommentController {
private final CommentService service;
private final ModelMapper mapper;
 @PostMapping
 @Authenticated
 public ResponseEntity<String> comentar(@RequestBody CommentDTO entity) {
    service.comentar(mapper.map(entity, Comment.class));

    return ResponseEntity.ok().body("Comentado");
 }
 @DeleteMapping
 @Authenticated
 public ResponseEntity<String> deletar(@RequestBody CommentDTO entity){
   service.deletarComment(mapper.map(entity, Comment.class).getId());

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletado");
 }

@PutMapping
@Authenticated
public ResponseEntity<String> update( @RequestBody CommentDTO entity) {
   service.update(mapper.map(entity, Comment.class));;
    return ResponseEntity.ok().body("Atualizado");
}
}