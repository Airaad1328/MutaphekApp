package com.gmail.clarkin200.MutaphekApp.service.post;

import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoResponse;
import com.gmail.clarkin200.MutaphekApp.entity.post.Post;
import com.gmail.clarkin200.MutaphekApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class PostServiceImpl implements PostService{

    PostRepository postRepository;

    public PostServiceImpl(@Qualifier("postRepository") PostRepository postRepository){

    }

    @Override
    public PostDtoResponse create(PostDtoRequest request) {
        return null;
    }

    @Override
    public List<PostDtoResponse> fetchAll() {
        return List.of();
    }

    @Override
    public PostDtoResponse findById(Long id) {
        return null;
    }

    @Override
    public PostDtoResponse updateById(Long id, PostDtoRequest request) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
