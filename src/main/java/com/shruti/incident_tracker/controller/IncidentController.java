package com.shruti.incident_tracker.controller;

import com.shruti.incident_tracker.entity.Incident;
import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.repository.IncidentRepository;
import com.shruti.incident_tracker.service.IncidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    @PostMapping
    public void createIncident(@RequestBody Incident incident) {
        incidentService.save(incident);
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @GetMapping("/{id}")
    public Incident findById(@PathVariable  Long id) {
        return incidentService.findById(id);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id, @RequestBody Incident updatedIncident) {
        return incidentService.updateIncident(id,updatedIncident);
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentService.deleteIncident(id);
    }

    @GetMapping("user/{userId}")
    public List<Incident> findAllIncidentsByUser(@PathVariable Long userId) {

        return incidentService.findIncidentsByUserId(userId);
    }


}
