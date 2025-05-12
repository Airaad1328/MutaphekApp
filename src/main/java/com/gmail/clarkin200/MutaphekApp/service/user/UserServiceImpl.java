package com.gmail.clarkin200.MutaphekApp.service.user;

import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoResponse;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoRequest;
import com.gmail.clarkin200.MutaphekApp.dto.user.UserSigninDtoResponse;
import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import com.gmail.clarkin200.MutaphekApp.entity.user.UserMapper;
import com.gmail.clarkin200.MutaphekApp.repository.UserRepository;
import com.gmail.clarkin200.MutaphekApp.service.security.JwtCore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private JwtCore jwtCore;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(@Qualifier("userRepository") UserRepository userRepository,
                           @Qualifier("userMapper") UserMapper userMapper,
                           @Qualifier("jwtCore") JwtCore jwtCore,
                           AuthenticationManager authenticationManager,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtCore = jwtCore;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDtoResponse create(UserDtoRequest request) {
        User newUser = userMapper.SignupRequestToEntity(request);
        String responseMessage;
        if (userRepository.findByName(newUser.getName()) != null) {
            responseMessage = "User with nickname " + newUser.getName() + "already exist";
            return UserDtoResponse.of(responseMessage, false, null);
        }
        if (userRepository.save(newUser) != null) {
            responseMessage = "User created successfully.";
            return UserDtoResponse.of(responseMessage, true, newUser);
        } else {
            responseMessage = "User has not been created!";
            return UserDtoResponse.of(responseMessage, false, null);
        }
    }

    @Override
    public List<UserDtoResponse> fetchAll() {
        return List.of();
    }

    @Override
    public UserDtoResponse findById(Long id) {
        return null;
    }

    @Override
    public UserDtoResponse updateById(Long id, UserDtoRequest request) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public UserSigninDtoResponse loginUser(UserSigninDtoRequest loginRequest) {
        Authentication authentication = null;
        User signedUser = userRepository.findByEmail(loginRequest.email());
        System.out.println(signedUser.getRoles());//TODO check null
        String responseMessage;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtCore.generateToken(authentication);
            responseMessage = "User signin success";
            return UserSigninDtoResponse.of(jwt,responseMessage,true,signedUser);
        } catch (BadCredentialsException e) {
            //TODO Check email and password whats wrong
            responseMessage = "Bad user credentials";
            return UserSigninDtoResponse.of(null,responseMessage,false,null);
        }
    }
}
