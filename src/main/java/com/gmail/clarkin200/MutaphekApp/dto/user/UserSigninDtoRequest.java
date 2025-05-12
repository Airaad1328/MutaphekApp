package com.gmail.clarkin200.MutaphekApp.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserSigninDtoRequest(String email,String password) {
}
