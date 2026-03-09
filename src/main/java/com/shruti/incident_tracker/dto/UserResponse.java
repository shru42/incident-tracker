package com.shruti.incident_tracker.dto;

import com.shruti.incident_tracker.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponse {

    private Long id;


    private String username;


    private String email;

    private Role role;

    private LocalDateTime createdAt;


}
