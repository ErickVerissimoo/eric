package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.PostDTO;
import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.service.PostService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;
import com.everyoneblogsspring.everyonesblogs.utils.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
@Validated
public class PostController {
private final PostService service;
private final UserMapper mapper;
@Authenticated
@PostMapping("postar")
public ResponseEntity<String> postar(@ModelAttribute @Valid PostDTO dto) {
    service.postar(mapper.toPost(dto));
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
