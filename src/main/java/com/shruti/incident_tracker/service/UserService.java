package com.shruti.incident_tracker.service;

import com.shruti.incident_tracker.entity.Role;
import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;


    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    public void registerUser(User user) {
//        user.setRole(Role.ENGINEER);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
//        Optional<User> user=userRepository.findByUsername(username);
//        return user;
        return userRepository.findByUsername(username);
    }

}
