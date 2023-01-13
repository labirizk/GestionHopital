package com.tutoriel.GestionHopital.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoriel.GestionHopital.DAO.RendezVousDAO;
import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;

@Service
public class RendezVousServiceImpl implements RendezVousService {
	
	@Autowired
	private RendezVousDAO rendezVousDAO;
	
	@Override
	public List<RendezVous> getLesRendezVous() {
		
		List<RendezVous> lesRendezVous = (List<RendezVous>) rendezVousDAO.findAll();
		if(!lesRendezVous.isEmpty()) {
			return lesRendezVous;
		}
		return null;
	}

	@Override
	public RendezVous getRendezVousByidRdv(Long idRdv) {
		// TODO Auto-generated method stub
		Optional<RendezVous> rendezVous = rendezVousDAO.findById(idRdv);
		if(rendezVous.isPresent()) {
			return rendezVous.get();
		}
		return null;
	}

	@Override
	public RendezVous saveRendezVous(RendezVous rendezVous) {
		
		RendezVous Rdv = new RendezVous();
		Rdv.setAdresseRdv(rendezVous.getAdresseRdv());
		Rdv.setDate(rendezVous.getDate());
		return Rdv;
	}

	
	@Override
	public void deleteRendezVousByidRdv(Long idRdv) {
		// TODO Auto-generated method stub
		rendezVousDAO.deleteById(idRdv);
		
	}
	
  //UPDATE ou remplacer l'ancien 
	
	@Override
	public RendezVous updateRendezVous(Long idRdv, RendezVous rendezVous) {
		// TODO Auto-generated method stub
		Optional<RendezVous> retrievedRendezVous = rendezVousDAO.findById(idRdv);
		RendezVous rdv = retrievedRendezVous.get();
		rdv.setAdresseRdv(rdv.getAdresseRdv());
		rdv.setDate(rdv.getDate());
		rendezVousDAO.save(rdv);
		return rdv;
	}

	@Override
	public void deleteLesRendezVous() {
		// TODO Auto-generated method stub
		rendezVousDAO.deleteAll();
	}


	@Override
	public List<RendezVous>  getLesRendezVousByPatient(Patient patient) {
		 //TODO Auto-generated method stub
		List<RendezVous> rdvs = rendezVousDAO.findByPatient(patient);
		if(!rdvs.isEmpty()) {
			return rdvs;
		}
		return null;
	}

	@Override
	public void deleteByID(Long idRdv) {
		// TODO Auto-generated method stub
		rendezVousDAO.deleteAll();
	}

	
}
