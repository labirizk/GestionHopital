package com.tutoriel.GestionHopital.service;

import java.util.List;

import com.tutoriel.GestionHopital.models.Patient;

public interface PatientService {
	
	
   List<Patient> getPatients();
	
   Patient getPatientByidPatient(Long idPatient);
   
   Patient savePatient(Patient patient);
   
   Patient updatePatient(Long idPatient,Patient patient);
	
   void deletePatientByidPatient(Long idPatient);

   void deletePatients();
	
	

}
