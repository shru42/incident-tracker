package com.shruti.incident_tracker.service;

import com.shruti.incident_tracker.entity.Incident;
import com.shruti.incident_tracker.entity.User;
import com.shruti.incident_tracker.repository.IncidentRepository;
import com.shruti.incident_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final UserRepository userRepository;

    public Incident save(Incident incident) {
        Long userId= incident.getCreatedBy().getId();
        if( userRepository.findById(userId).isEmpty() ) {
            throw new RuntimeException("User with id " + userId + " not found");
        }
        return incidentRepository.save(incident);
    }

    public Incident findById(Long id) {
        Optional<Incident> incident = incidentRepository.findById(id);
        if(incident.isEmpty()) {
            throw new RuntimeException("Incident with id " + id + " not found");
        }
       return incident.get();
    }

    public List<Incident> findByCreatedBy(User createdby) {
        if(userRepository.findByUsername(createdby.getUsername()).isEmpty())
            throw new RuntimeException("User with name " + createdby.getUsername() + " not found");
        return incidentRepository.findByCreatedBy(createdby);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public void deleteIncident(Long id){
        incidentRepository.deleteById(id);
    }

    public Incident updateIncident(Long id, Incident updatedIncident) {
      Incident existing = findById(id);
      existing.setTitle(updatedIncident.getTitle());
      existing.setDescription(updatedIncident.getDescription());
      existing.setSeverity(updatedIncident.getSeverity());
      existing.setStatus(updatedIncident.getStatus());

      return incidentRepository.save(existing);

    }

}
