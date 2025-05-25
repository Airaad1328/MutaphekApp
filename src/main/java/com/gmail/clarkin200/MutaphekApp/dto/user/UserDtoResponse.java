package com.gmail.clarkin200.MutaphekApp.dto.user;

import com.gmail.clarkin200.MutaphekApp.entity.role.Role;
import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public record UserDtoResponse(int statusCode,
                              String reasonPhrase,
                              boolean success,
                              String message,
                              String userName,
                              String userEmail,
                              List<Role> userRole) {

    public static UserDtoResponse of(String message,boolean isUserCreate, User user) {
        return isUserCreate ?
                new UserDtoResponse(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        true, message, user.getName(), user.getName(), user.getRoles())
                :
                new UserDtoResponse(
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        false, message, null,null,null);
    }
}
