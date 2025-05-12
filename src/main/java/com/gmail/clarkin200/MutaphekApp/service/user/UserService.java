package com.gmail.clarkin200.MutaphekApp.service.user;


import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoResponse;
import com.gmail.clarkin200.MutaphekApp.service.BaseService;

public interface UserService extends BaseService<UserDtoResponse, UserDtoRequest> {
    UserSigninDtoResponse loginUser (UserSigninDtoRequest loginRequest);
}
