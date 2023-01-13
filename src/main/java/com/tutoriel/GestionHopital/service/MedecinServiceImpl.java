package com.tutoriel.GestionHopital.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutoriel.GestionHopital.DAO.MedecinDAO;
import com.tutoriel.GestionHopital.models.Medecin;

@Service
public class MedecinServiceImpl implements MedecinService {
	
	@Autowired
	private MedecinDAO medecinDAO;
	
	//GET MEDECIN 
	@Override
	public List<Medecin> getMedecins() {
		
		List<Medecin> MED = (List<Medecin>) medecinDAO.findAll();
		if(!MED.isEmpty()) {
			return MED;
		}
		else {
			return null;
		}
	}
	
	//SAVE MEDECIN
	@Override
	public Medecin saveMedecin(Medecin medecin) {
		
		Medecin mede = new Medecin();
		mede.setNom(medecin.getNom());
		mede.setSpecialite(medecin.getSpecialite());
		medecinDAO.save(mede);
		return mede;
		
	}

	
	//GET MEDECIN BY ID
	@Override
	public Medecin getMedecinByID(Long id) {
		
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(id);
		if(retrievedMedecin.isPresent()) {
			return retrievedMedecin.get();
		}
		else {
			return null;
		}
		
	}
	
	
	// UPDATE MEDECIN 
	
	@Override
	public Medecin updateMedecin(Long id, Medecin medecin) {
		
		Optional<Medecin> retrievedMedecin = medecinDAO.findById(id);
		
		Medecin mede = retrievedMedecin.get();
		
		mede.setNom(mede.getNom());
		mede.setSpecialite(mede.getSpecialite());
		medecinDAO.save(mede);
		return mede;
	}
	
	// DELETE Medecin BY ID

	@Override
	public void deleteMedecinByID(Long id) {
		// TODO Auto-generated method stub
		medecinDAO.deleteById(id);
	}
	
	
	//DELETE MEDECINS
	
	@Override
	public void deleteMedecins() {
		medecinDAO.deleteAll();
	}



}
