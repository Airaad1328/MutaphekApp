package com.gmail.clarkin200.MutaphekApp.service.post;

import com.gmail.clarkin200.MutaphekApp.dto.post.FetchPostsDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateRequest;
import com.gmail.clarkin200.MutaphekApp.dto.post.PostDtoCreateResponse;
import com.gmail.clarkin200.MutaphekApp.service.BaseService;

public interface PostService extends BaseService<PostDtoCreateResponse, PostDtoCreateRequest> {
    FetchPostsDtoResponse fetchPosts ();
}
