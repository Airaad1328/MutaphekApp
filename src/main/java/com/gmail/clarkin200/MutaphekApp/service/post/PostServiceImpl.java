package com.gmail.clarkin200.MutaphekApp.service.post;

import com.gmail.clarkin200.MutaphekApp.dto.post.FetchPostsDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDto;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateRequest;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateResponse;
import com.gmail.clarkin200.MutaphekApp.entity.post.Post;
import com.gmail.clarkin200.MutaphekApp.entity.post.PostMapper;
import com.gmail.clarkin200.MutaphekApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    private PostMapper postMapper;

    public PostServiceImpl(@Qualifier("postRepository") PostRepository postRepository,
                           @Qualifier("postMapper") PostMapper postMapper){
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDtoCreateResponse create(PostDtoCreateRequest request) {
        Post toCreate = postMapper.requestToEntity(request);
        if(postRepository.save(toCreate) != null){
            return PostDtoCreateResponse.of("Post created",true,toCreate);
        }
        return PostDtoCreateResponse.of("Post is not created",false,null);

    }

    @Override
    public FetchPostsDtoResponse fetchPosts() {
        List<Post> fetchedPosts = postRepository.findAll();
        List<PostDto> mappedPosts = postMapper.entityListToListResponse(fetchedPosts);
        if(fetchedPosts != null ) {
            return FetchPostsDtoResponse.of(true,mappedPosts);
        }
        return FetchPostsDtoResponse.of(false,null);
    }

    @Override
    public List<PostDtoCreateResponse> fetchAll() {
        return List.of();
    }

    @Override
    public PostDtoCreateResponse findById(Long id) {
        return null;
    }

    @Override
    public PostDtoCreateResponse updateById(Long id, PostDtoCreateRequest request) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

}
