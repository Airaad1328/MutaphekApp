package com.gmail.clarkin200.MutaphekApp.repository;

import com.gmail.clarkin200.MutaphekApp.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findPostByUserId(Long userId);
}
