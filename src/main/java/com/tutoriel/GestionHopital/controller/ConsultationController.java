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

import com.tutoriel.GestionHopital.models.Consultation;
import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.service.ConsultationService;

@RestController
@RequestMapping(path = "/api/consultations" )


public class ConsultationController {
	
	@Autowired
	private ConsultationService consultationService;
	
	@GetMapping(path="/")
	public ResponseEntity<List<Consultation>> getConsultations() {
		
		try {
			List<Consultation> Consultations =  consultationService.getConsultations();
			return new ResponseEntity<>(Consultations, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
		@PostMapping(path = "/")
		public ResponseEntity<Consultation>  saveconsultation(@RequestBody Consultation consultation) {
			try {
				return new ResponseEntity<>(consultationService.saveConsultation(consultation), HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			 
		}		
		
		
		@GetMapping(path = "/{idConsultation}")
		public ResponseEntity<Consultation> getConsultationByidConsultation(@PathVariable Long idConsultation) {
			try {
				Consultation cons = consultationService.getConsultationByID(idConsultation);
				if(cons != null) {
					return new ResponseEntity<>(cons, HttpStatus.OK);
				}
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		

		@GetMapping(path = "/patient")
		public ResponseEntity<List<Consultation>> getConsultationByPatient(@RequestBody Patient patient){
		try {
		return new ResponseEntity<List<Consultation>>(consultationService.getConsultationByPatient(patient),HttpStatus.OK);
		} catch (Exception e) {
				// TODO: handle exception
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		
	
		@PutMapping(path = "/{idConsultation}")
		public ResponseEntity<Consultation>  updateConsultation(@PathVariable Long idConsultation,@RequestBody Consultation consultation) {
			try {
				return new ResponseEntity<Consultation>(consultationService.updateConsultation(idConsultation, consultation), HttpStatus.OK) ;
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@DeleteMapping(path = "/{idConsultation}")
		 public void deleteConsultationByID(@PathVariable Long idConsulation) {
			consultationService.deleteConsultationByID(idConsulation);
		 }
		 
		@DeleteMapping(path = "/")
		 public void deleteConsultations() {
			 consultationService.deleteConsultations();
		 }

		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
	

}