package com.exemple.GestionHopital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tutoriel.GestionHopital.controller.RendezVousController;
import com.tutoriel.GestionHopital.models.RendezVous;
import com.tutoriel.GestionHopital.service.RendezVousService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)

public class RendezVousControllerTest {

	@InjectMocks
	private RendezVousController rendezVousController = new RendezVousController();
	
	@Mock
	private RendezVousService rendezVousService;
	
	
	@Test
	public void getRendezVous_withoutException_Test() {
		
		//Given 
		List<RendezVous> list = new ArrayList<>();
		
		RendezVous firstRendezVous = new RendezVous();
		RendezVous secondRendezVous = new RendezVous();
		
		list.add(secondRendezVous);
		list.add(firstRendezVous);
		
		//When 
		Mockito.when(rendezVousService.getLesRendezVous()).thenReturn(list);
		ResponseEntity<List<RendezVous>> rendezVouslist = rendezVousController.getLesRendezVous();
		
		
		//Then 
		assertEquals(HttpStatus.OK, rendezVouslist.getStatusCode());
	}
	
	
	@Test
	public void getLesRendezVous_withException_Test() {
		
		when(rendezVousService.getLesRendezVous()).thenThrow(new NullPointerException("Error occurred"));
		Assert.assertTrue(rendezVousController.getLesRendezVous().getStatusCode() ==  HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	
	@Test
	public void getRendezVousByidRdv() throws Exception {
		//given
		
		RendezVous rendezVous = new RendezVous ();
		
		rendezVous.setIdRdv(2L);
		
		// When 
		
	Mockito.when(rendezVousService.getRendezVousByidRdv(2L)).thenThrow(new NullPointerException("Error occured"));
	ResponseEntity<RendezVous> response = rendezVousController.getRendezVousByidRdv(2L);

		
		//Then
	assertEquals(HttpStatus.OK, response.getStatusCode());	
		
	}
	
	////////////////////////////////////////////////:
	
	@Test
	public void createBook_WhitoutException() throws Exception {
		
		//given
		RendezVous rendezVous = new RendezVous();
		rendezVous.setIdRdv(3L);
		rendezVous.setAdresseRdv("CHU Nantes");
		rendezVous.setDate(null);

		
		//When
		Mockito.when(rendezVousService.saveRendezVous(rendezVous)).thenReturn(rendezVous);
		ResponseEntity<RendezVous> response = rendezVousController.saveRendezVous(rendezVous);
		
		//Then
		assertThat(response.getBody().getIdRdv()).isGreaterThan(0);
		
	}
	

	//Supprimer Un  de ma base de données by IdRdv
		//En sachant que la méthode deleteByIdRdv est déja défini dans le Controller
		//on a inejcter le controller avec Mocker, par conséquent la méthode deleteByIdRdv on aussi été mocker...
		
	@Test
	public void deleteByIdRdv() throws Exception {
		
		
		//given
				RendezVous rendezVous = new RendezVous();
				rendezVous.setIdRdv(30L);
				rendezVous.setAdresseRdv("CHU Nantes");
				rendezVous.setDate(null);
		
		//When
		rendezVousController.deleteByIdRdv(30L);
		ResponseEntity<RendezVous> retrievedRendezVous = rendezVousController.getRendezVousByidRdv(rendezVous.getIdRdv());
		
		//Then
		assertThat(retrievedRendezVous.getBody()).isNull();
	}
	
	@Test
	public void  deleteLesRendezVous() throws Exception {
		
		RendezVous rendezVous = new RendezVous();
		rendezVous.setIdRdv(30L);
		rendezVous.setAdresseRdv("CHU Nantes");
		rendezVous.setDate(null);
		
		rendezVousController.deleteAll();
		ResponseEntity<RendezVous> retrievedRendezVous = rendezVousController.getRendezVousByidRdv(rendezVous.getIdRdv());
		
		//Then
		
		assertThat(retrievedRendezVous.getBody()).isNull();
		
	}


	
}
