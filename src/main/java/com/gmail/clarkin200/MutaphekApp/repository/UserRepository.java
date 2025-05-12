package com.gmail.clarkin200.MutaphekApp.repository;

import com.gmail.clarkin200.MutaphekApp.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByName(String name);
}
