package com.tutoriel.GestionHopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoriel.GestionHopital.DAO.PatientDAO;
import com.tutoriel.GestionHopital.models.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public List<Patient> getPatients() {
		
		List<Patient> patients = (List<Patient>) patientDAO.findAll();
		if(!patients.isEmpty()) {
			return patients;
		}
		return null;
	}

	@Override
	public Patient getPatientByidPatient(Long idPatient) {
		// TODO Auto-generated method stub
		Optional<Patient> patient = patientDAO.findById(idPatient);
		if(patient.isPresent()) {
			return patient.get();
		}
		return null;
	}

	

	@Override
	public void deletePatientByidPatient(Long idPatient) {
		// TODO Auto-generated method stub
		patientDAO.deleteById(idPatient);
		
	}
	
	
	@Override
		public Patient savePatient(Patient patient) {
		Patient Rdv = new Patient();
		
		Rdv.setNomPatient(patient.getNomPatient());
		Rdv.setNumSecu(patient.getNumSecu());
		return Rdv;
	
	}

	@Override
	public Patient updatePatient(Long idPatient, Patient patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatients() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
