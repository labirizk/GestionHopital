package com.tutoriel.GestionHopital.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;

@Repository
public interface RendezVousDAO extends CrudRepository<RendezVous, Long> {
	
	List<RendezVous> findByPatient(Patient patient);	
}
