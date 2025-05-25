package com.gmail.clarkin200.MutaphekApp.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties
public record PostDto(String content, String creationDate, String userName) {
}
