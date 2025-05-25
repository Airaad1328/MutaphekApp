package com.gmail.clarkin200.MutaphekApp.entity.post;

import com.gmail.clarkin200.MutaphekApp.dto.post.PostDto;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateRequest;
import com.gmail.clarkin200.MutaphekApp.entity.user.UserPrincipal;
import com.gmail.clarkin200.MutaphekApp.repository.UserRepository;
import com.gmail.clarkin200.MutaphekApp.service.security.JwtCore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component("postMapper")
public class PostMapper {
    private JwtCore jwtCore;
    private UserRepository userRepository;

    public PostMapper (@Qualifier("jwtCore") JwtCore jwtCore,
                       @Qualifier("userRepository") UserRepository userRepository) {
        this.jwtCore = jwtCore;
        this.userRepository = userRepository;
    }

    public Post requestToEntity(PostDtoCreateRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Post newPost = new Post();
        newPost.setUser(userRepository.findByEmail(userPrincipal.getUsername()));
        newPost.setContent(request.content());
        return newPost;
    }

    public List<PostDto> entityListToListResponse (List<Post> posts) {
        return posts.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    public PostDto entityToResponse (Post post) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm");
        return new PostDto(post.getContent(),post.getCreationDate().format(formatter),
                post.getUser().getName());
    }
}
