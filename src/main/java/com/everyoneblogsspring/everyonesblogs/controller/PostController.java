package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.dto.postDTO;
import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.repository.postRepository;
import com.everyoneblogsspring.everyonesblogs.service.PostService;
import com.everyoneblogsspring.everyonesblogs.utils.Authenticated;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
@Validated
public class PostController {
private final PostService service;
@Authenticated
@PostMapping("postar")
public ResponseEntity<String> postar(@ModelAttribute @Valid postDTO dto) {
    service.postar(dto.toEntity(Post.class));
    return ResponseEntity.ok().body("Postado");
}


}
