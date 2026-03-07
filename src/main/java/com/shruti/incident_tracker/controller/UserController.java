package com.shruti.incident_tracker.controller;

import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {


    public final UserService userService;

    @PostMapping("/register")
    public void registerUser( @RequestBody User user) {
        userService.registerUser(user);
    }

    @GetMapping("/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
