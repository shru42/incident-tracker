package com.shruti.incident_tracker.repository;

import com.shruti.incident_tracker.entity.Incident;
import com.shruti.incident_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByCreatedById(Long userId);
}
