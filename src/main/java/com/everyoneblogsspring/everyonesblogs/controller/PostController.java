package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.PostDTO;
import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.service.PostService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.ServletRequestUtils;;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
@Validated
public class PostController {
private final PostService service;
private final ModelMapper mapper;
@Authenticated
@PostMapping("postar")
public ResponseEntity<String> postar(@ModelAttribute @Valid PostDTO dto) {
    service.postar(mapper.map(dto, Post.class));
    return ResponseEntity.ok().body("Postado");
}
@Authenticated
@DeleteMapping("/{id}")
public ResponseEntity<String> apagar(@PathVariable String id){
    service.deletar(UUID.fromString(id));
return ResponseEntity.status(HttpStatus.OK).body("deletado");
}
@PutMapping("/{id}")
@Authenticated
public ResponseEntity<String> update(@PathVariable String id, @RequestBody PostDTO entity) {
    service.update(UUID.fromString(id), entity);

    return ResponseEntity.ok().body("Atualizado");
}
@GetMapping("/{id}")
public ResponseEntity<Post> getOne(@PathVariable String id) {
    return ResponseEntity.ok().body(service.findOne(UUID.fromString(id)));
}

}
