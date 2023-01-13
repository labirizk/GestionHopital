package com.tutoriel.GestionHopital.service;

import java.util.List;

import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;

public interface RendezVousService {
	
	List<RendezVous> getLesRendezVous();
	
	RendezVous getRendezVousByidRdv(Long idRdv);
	
	RendezVous saveRendezVous(RendezVous rendezVous);
	
	void deleteRendezVousByidRdv(Long idRdv);

	RendezVous updateRendezVous(Long idRdv, RendezVous rendezVous);

	void deleteLesRendezVous();
	
	void deleteByID(Long idRdv);

	List<RendezVous> getLesRendezVousByPatient(Patient patient);
	
}
