package com.gmail.clarkin200.MutaphekApp.controller;

import com.gmail.clarkin200.MutaphekApp.dto.post.FetchPostsDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateRequest;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateResponse;
import com.gmail.clarkin200.MutaphekApp.service.post.PostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private PostService postService;
    public PostController(@Qualifier("postService") PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<FetchPostsDtoResponse> fetchAllPosts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.fetchPosts());
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDtoCreateResponse> createPost(@RequestBody PostDtoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(postService.create(request));
    }
}
