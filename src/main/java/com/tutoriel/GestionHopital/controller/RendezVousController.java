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
import com.tutoriel.GestionHopital.models.RendezVous;
import com.tutoriel.GestionHopital.service.RendezVousService;

@RestController
@RequestMapping(path = "/api/lesRendezVous" )


public class RendezVousController {
	
	@Autowired
	private RendezVousService rendezVousService;
	
	@GetMapping(path="/")
	public ResponseEntity<List<RendezVous>> getLesRendezVous() {
		
		try {
			List<RendezVous> LesRendezVous =  rendezVousService.getLesRendezVous();
			return new ResponseEntity<>(LesRendezVous, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
		
		@PostMapping(path = "/")
		public ResponseEntity<RendezVous>  saveRendezVous(@RequestBody RendezVous rendezVous) {
			try {
				return new ResponseEntity<>(rendezVousService.saveRendezVous(rendezVous), HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			 
		}		
		
		
		@GetMapping(path = "/{idRdv}")
		public ResponseEntity<RendezVous> getRendezVousByidRdv(@PathVariable Long idRdv) {
			try {
				RendezVous Rdv = rendezVousService.getRendezVousByidRdv(idRdv);
				if(Rdv != null) {
					return new ResponseEntity<>(Rdv, HttpStatus.OK);
				}
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		
		@GetMapping(path = "/patient")
		public ResponseEntity<List<RendezVous>> getLesRendezVousByPatient(@RequestBody Patient patient){
		try {
		return new ResponseEntity<List<RendezVous>>(rendezVousService.getLesRendezVousByPatient(patient),HttpStatus.OK);
		} catch (Exception e) {
				// TODO: handle exception
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
		
	
		@PutMapping(path = "/{idRdv}")
		public ResponseEntity<RendezVous>  updateRendezVous(@PathVariable Long idRdv,@RequestBody RendezVous rendezVous) {
			try {
				return new ResponseEntity<RendezVous>(rendezVousService.updateRendezVous(idRdv, rendezVous), HttpStatus.OK) ;
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
		@DeleteMapping(path = "/{idRdv}")
		 public void deleteByIdRdv(@PathVariable Long idRdv) {
			  rendezVousService.deleteRendezVousByidRdv(idRdv);
		 }
		 
		@DeleteMapping(path = "/")
		 public void deleteLesRendezVous() {
			 rendezVousService.deleteLesRendezVous();
		 }

		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
	

}
