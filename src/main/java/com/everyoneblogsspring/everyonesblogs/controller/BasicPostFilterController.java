package com.everyoneblogsspring.everyonesblogs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.everyoneblogsspring.everyonesblogs.model.Post;
import com.everyoneblogsspring.everyonesblogs.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post/filter/")
public class BasicPostFilterController {
private final PostService service;

@GetMapping("last")
public ResponseEntity<List<Post>> getLasts() {
    return ResponseEntity.ok(service.lastPosts());
}


}
