package com.shruti.incident_tracker.controller;

import com.shruti.incident_tracker.dto.LoginRequest;
import com.shruti.incident_tracker.dto.UserResponse;
import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {


    private final UserService userService;

    @PostMapping("/register")
    public void registerUser( @RequestBody User user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
       return userService.loginUser(request.getUsername(), request.getPassword());
    }

    @GetMapping("/{username}")
    public UserResponse findByUsername(@PathVariable String username) {
        Optional<User> optionalUser= userService.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        User user = optionalUser.get();
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getCreatedAt());
    }
}
