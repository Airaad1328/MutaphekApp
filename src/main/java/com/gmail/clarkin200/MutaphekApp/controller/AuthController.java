package com.gmail.clarkin200.MutaphekApp.controller;

import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoResponse;
import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import com.gmail.clarkin200.MutaphekApp.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private UserService userService;

    public AuthController(@Qualifier("userService")UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<UserSigninDtoResponse> getLoginForm(@RequestBody UserSigninDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.loginUser(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDtoResponse> loginUser(@RequestBody UserDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.create(request));
    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.OK).body("HelloWorld");
    }


}
