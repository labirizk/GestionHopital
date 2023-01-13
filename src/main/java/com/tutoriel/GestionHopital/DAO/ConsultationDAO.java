package com.tutoriel.GestionHopital.DAO;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tutoriel.GestionHopital.models.Consultation;
import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;

@Repository
public interface ConsultationDAO extends  CrudRepository<Consultation, Long>{
	
	List<Consultation> findByIdRdv(RendezVous rendezVous);
	
	List<Consultation> findByPatient(Patient patient);	
}
