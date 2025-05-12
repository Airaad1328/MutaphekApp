package com.gmail.clarkin200.MutaphekApp.dto.user;

import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import org.springframework.http.HttpStatus;

public record UserSigninDtoResponse(int statusCode,
                                    String reasonPhrase,
                                    boolean success,
                                    String message,
                                    String jwt,
                                    UserResponse user /*TODO Avatar*/) {
    public static UserSigninDtoResponse of (String jwt,String message,boolean isSignin,User user){
        return isSignin ?
                new UserSigninDtoResponse(
                       HttpStatus.OK.value(),
                       HttpStatus.OK.getReasonPhrase(),
                       true,message,jwt,UserResponse.of(user))
                :
                new UserSigninDtoResponse(
                        HttpStatus.UNAUTHORIZED.value(),
                        HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                        false,message,null,null);
    }
    public record UserResponse(String name,String email){
        public static  UserResponse of(User user){
            return new UserResponse(user.getName(), user.getEmail());
        }
    }
    ;
}

