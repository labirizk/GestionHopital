package com.exemple.GestionHopital.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tutoriel.GestionHopital.controller.MedecinController;
import com.tutoriel.GestionHopital.models.Medecin;
import com.tutoriel.GestionHopital.service.MedecinService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {
	
	@InjectMocks
	private MedecinController medecinController = new MedecinController();
	
	@Mock 
	private MedecinService medecinService;
	
	@Test //org.junit
	public void getMedecins_withoutException_Test() {
		
		// First Step : Given
		List<Medecin> list = new ArrayList<>();
		

		Medecin firstMedecin = new Medecin();
		Medecin secondMedecin = new Medecin();
		
		list.add(firstMedecin);
		list.add(secondMedecin);
		
		
		// Second Step : When
		Mockito.when(medecinService.getMedecins()).thenReturn(list);
		ResponseEntity<List<Medecin>> medecinlist = medecinController.getMedecins();
	
		// Third Step : Then
		assertEquals(HttpStatus.OK, medecinlist.getStatusCode());
			
	}
	
	
	@Test
	public void getMedecins_withException_Test() {
		when(medecinService.getMedecins()).thenThrow(new NullPointerException("Error occurred"));
		Assert.assertTrue(medecinController.getMedecins().getStatusCode() ==  HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@Test
	public void getMedecinByID() throws Exception {
		
		//Given : on met notre test dans un état connu 
		Medecin medecin = new Medecin(); 
		
		medecin.setId(2L);
		
		//When la condition de test qui genere le then 
		//Call méthode avec mock
		when(medecinService.getMedecinByID(2L)).thenReturn(medecin);
		ResponseEntity<Medecin> response = medecinController.getMedecinByID(2L);
		
		// Then : affirmer, assurer 
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		}
	
	
	//Tester la création d'un medecin
	
		@Test
		public void createMedecin_WhitoutException() throws Exception{
			
		//Given
			
			Medecin medecin = new Medecin();
			medecin.setId(3L);
			medecin.setNom("Dubrasquet Lannot");
			medecin.setSpecialite("Ophtalmologue");
			
		//When
			when(medecinService.saveMedecin(medecin)).thenReturn(medecin);
			ResponseEntity<Medecin> resp = medecinController.saveMedecin(medecin);
			
		//Then 
			assertThat(resp.getBody().getId()).isGreaterThan(0);

		}
	
		
		//Supprimer un medecin de ma BD

		@Test
		public void deleteByID() throws Exception {
			
			//Given
			Medecin medecin = new Medecin();
			medecin.setId(3L);
			medecin.setNom("Dubrasquet Lannot");
			medecin.setSpecialite("Ophtalmologue");
			
			//When
			medecinController.deleteMedecinByID(3L);
			ResponseEntity<Medecin> retrievedMedecin = medecinController.getMedecinByID(medecin.getId());;
			
			//Then
			assertThat(retrievedMedecin.getBody()).isNull();
			
		}


}
