package com.tutoriel.GestionHopital.service;

import java.util.List;

import com.tutoriel.GestionHopital.models.Consultation;
import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;

public interface ConsultationService {
    
    List<Consultation> getConsultations();
    
    Consultation saveConsultation(Consultation consultation);
    
    Consultation getConsultationByID(Long idConsulation);
    
    Consultation updateConsultation(Long idConsulation,Consultation consultation);
    
    
    void deleteConsultationByID(Long idConsulation);
    
    void deleteConsultations();

    List<Consultation> getConsultationByIdRdv(RendezVous rendezVous);
	List<Consultation> getConsultationByPatient(Patient patient);
    

}