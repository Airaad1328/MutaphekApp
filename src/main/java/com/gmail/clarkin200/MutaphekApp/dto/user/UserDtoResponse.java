package com.gmail.clarkin200.MutaphekApp.dto.user;

import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import org.springframework.http.HttpStatus;

public record UserDtoResponse(int statusCode,
                              String reasonPhrase,
                              boolean success,
                              String message,
                              User user) {

    public static UserDtoResponse of(String message,boolean isUserCreate, User user) {
        return isUserCreate ?
                new UserDtoResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true, message, user)
                :
                new UserDtoResponse(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        false, message, null);
    }
}
