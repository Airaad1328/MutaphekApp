package com.gmail.clarkin200.MutaphekApp.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gmail.clarkin200.MutaphekApp.entity.post.Post;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDtoCreateResponse(int statusCode,
                                    String reasonPhrase,
                                    String message,
                                    Long id, String userName,
                                    String content,
                                    LocalDateTime creationDate) {
    //TODO AVATAR
    public static PostDtoCreateResponse of (String message, boolean isPostCreate, Post post) {
        return isPostCreate ?
                new PostDtoCreateResponse(HttpStatus.OK.value(),
                                    HttpStatus.OK.getReasonPhrase(),
                                    message,
                                    post.getId(),post.getUser().getName(),
                                    post.getContent(),post.getCreationDate())
                :
                new PostDtoCreateResponse(HttpStatus.NOT_FOUND.value(),
                                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                                    message,
                                    null,null,null,null);

    }
}
