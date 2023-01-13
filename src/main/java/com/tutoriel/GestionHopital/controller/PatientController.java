package com.tutoriel.GestionHopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.service.PatientService;

@RestController
@RequestMapping(path = "/api/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;

	@GetMapping(path = "/")
	public ResponseEntity<List<Patient>> getPatients(){
		try {
			List<Patient> patients = patientService.getPatients();
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		try {
			return new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@GetMapping(path = "/{idPatient}")
	public ResponseEntity<Patient> getPatientByidPatient(@PathVariable Long idPatient){
		try {
			if(patientService.getPatientByidPatient(idPatient) != null) {
				return new ResponseEntity<Patient>(patientService.getPatientByidPatient(idPatient), HttpStatus.OK);
			}
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{idPatient}")
	public ResponseEntity<Patient>  updatePatient(@PathVariable Long idPatient,@RequestBody Patient patient) {
		try {
			return new ResponseEntity<Patient>(patientService.updatePatient(idPatient, patient), HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@DeleteMapping(path = "/{idPatient}")
	public void deletePatientByidPatient(@PathVariable Long idPatient) {
		patientService.deletePatientByidPatient(idPatient);
	}

	
	@DeleteMapping(path = "/")
	 public void deletePatients() {
		 patientService.deletePatients();
	 }
	
}
