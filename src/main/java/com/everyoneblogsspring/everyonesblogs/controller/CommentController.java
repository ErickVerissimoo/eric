package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;

import com.everyoneblogsspring.everyonesblogs.dto.CommentDTO;
import com.everyoneblogsspring.everyonesblogs.model.Comment;
import com.everyoneblogsspring.everyonesblogs.service.CommentService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
 public ResponseEntity<String> deletar(){
    

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletado");
 }


}