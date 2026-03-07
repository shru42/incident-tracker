package com.shruti.incident_tracker.repository;

import com.shruti.incident_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

//    Why Optional? — It forces the caller to handle the "user not found" case explicitly.
    Optional<User> findByUsername(String username);

}
