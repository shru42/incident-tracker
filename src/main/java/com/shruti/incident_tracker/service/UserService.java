package com.shruti.incident_tracker.service;

import com.shruti.incident_tracker.entity.Role;
import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.repository.UserRepository;
import com.shruti.incident_tracker.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    public void registerUser(User user) {
//        user.setRole(Role.ENGINEER);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public String loginUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            if(encoder.matches(password, user.get().getPassword())) {
                return jwtUtil.generateToken(username);
            }
        }
        throw new UsernameNotFoundException("Username not found");
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
