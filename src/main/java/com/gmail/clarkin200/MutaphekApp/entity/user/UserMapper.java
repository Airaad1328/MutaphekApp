package com.gmail.clarkin200.MutaphekApp.entity.user;

import com.gmail.clarkin200.MutaphekApp.dto.user.UserDtoRequest;
import com.gmail.clarkin200.MutaphekApp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userMapper")
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserMapper(PasswordEncoder passwordEncoder,
                      @Qualifier("roleRepository") RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User SignupRequestToEntity(UserDtoRequest request){
        User newUser = new User();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setActive(true);
        newUser.getRoles().add(roleRepository.findById(2L).get());
        return newUser;
    }
}
