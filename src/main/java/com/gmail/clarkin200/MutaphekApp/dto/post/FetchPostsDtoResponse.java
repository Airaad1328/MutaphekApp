package com.gmail.clarkin200.MutaphekApp.dto.post;

import com.gmail.clarkin200.MutaphekApp.entity.post.Post;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public record FetchPostsDtoResponse(int statusCode,
                                    String reasonPhrase,
                                    String message,
                                    List<PostDto> posts) {
    public static FetchPostsDtoResponse of (boolean isSuccess,  List<PostDto> posts) {
        return isSuccess ?
                new FetchPostsDtoResponse(HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        "Fetch posts successfully", posts)
                :
                new FetchPostsDtoResponse(HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        "Fetch posts is denied", null);
    }
}
