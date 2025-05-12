package com.gmail.clarkin200.MutaphekApp.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDtoResponse(Long id, String userName, String userAvatar, String content,
                              LocalDateTime creationDate) {
}
