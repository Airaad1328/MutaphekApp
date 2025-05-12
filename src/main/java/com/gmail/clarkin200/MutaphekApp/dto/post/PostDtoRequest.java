package com.gmail.clarkin200.MutaphekApp.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PostDtoRequest() {
}
