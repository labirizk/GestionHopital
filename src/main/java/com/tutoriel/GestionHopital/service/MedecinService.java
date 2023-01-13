package com.tutoriel.GestionHopital.service;

import java.util.List;
import com.tutoriel.GestionHopital.models.Medecin;


public interface MedecinService {
	
	List<Medecin> getMedecins();
	
	Medecin saveMedecin(Medecin medecin);
	
	Medecin getMedecinByID(Long id);
	
	Medecin updateMedecin(Long id,Medecin medecin);
	
	void deleteMedecinByID(Long id);
	
	void deleteMedecins();
	
	
	

}
