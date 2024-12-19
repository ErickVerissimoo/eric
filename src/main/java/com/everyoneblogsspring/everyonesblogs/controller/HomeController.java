package com.everyoneblogsspring.everyonesblogs.controller;

import org.springframework.web.bind.annotation.RestController;

import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.service.PostService;
import com.everyoneblogsspring.everyonesblogs.service.userService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/home")
public class HomeController {
    private final userService userService;
    private final PostService postService;

@GetMapping("/")
public ResponseEntity<List<Post>> getAll() {
    return ResponseEntity.ok(postService.getAllPosts());
}
@GetMapping("/{id}")
public ResponseEntity<Post> getOne(@PathVariable String id) {

    return ResponseEntity.ok(postService.findOne(UUID.fromString(id)));
}

}
