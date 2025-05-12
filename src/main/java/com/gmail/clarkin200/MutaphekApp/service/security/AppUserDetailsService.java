package com.gmail.clarkin200.MutaphekApp.service.security;

import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import com.gmail.clarkin200.MutaphekApp.entity.user.UserPrincipal;
import com.gmail.clarkin200.MutaphekApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    public AppUserDetailsService(@Qualifier("userRepository") UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Invalid email or password");
        }
        return new UserPrincipal(user);
    }
}
