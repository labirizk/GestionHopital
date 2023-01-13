package com.tutoriel.GestionHopital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoriel.GestionHopital.DAO.ConsultationDAO;
import com.tutoriel.GestionHopital.models.Consultation;
import com.tutoriel.GestionHopital.models.Patient;
import com.tutoriel.GestionHopital.models.RendezVous;


@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	private ConsultationDAO consultationDAO;
	
	@Override
	public List<Consultation> getConsultations() {
		
		List<Consultation> consultations = (List<Consultation>) consultationDAO.findAll();
		if(!consultations.isEmpty()) {
			return consultations;
		}
		return null;
	}
	
	
	@Override
	public Consultation getConsultationByID(Long idConsulation) {
		// TODO Auto-generated method stub
		Optional<Consultation> consultation = consultationDAO.findById(idConsulation);
		if(consultation.isPresent()) {
			return consultation.get();
		}
		return null;
	}

	//Ajouter consultation
	@Override
	public Consultation saveConsultation(Consultation consultation) {
		
		Consultation cons = new Consultation();
		cons.setDiagnostic(consultation.getDiagnostic());
		return cons;
	}
	
	//Supprimer consultation
	
	@Override
	public void deleteConsultationByID(Long idConsulation) {
		// TODO Auto-generated method stub
		consultationDAO.deleteById(idConsulation);
		
	}
	
	//Update Consultation
	
	@Override
	public Consultation updateConsultation(Long idConsulation,Consultation consultation) {
		// TODO Auto-generated method stub
		Optional<Consultation> retrievedConsultation = consultationDAO.findById(idConsulation);
		Consultation cons = retrievedConsultation.get();
		cons.setDiagnostic(consultation.getDiagnostic());
		consultationDAO.save(cons);
		return cons;
	}

	//supprimer toutes les ConsultationS
	
	@Override
	public void deleteConsultations() {
		// TODO Auto-generated method stub
		consultationDAO.deleteAll();
	}

	//Get les Consultations par Patient et par RendezVous (Croisement de tables)
	
	
	@Override
	public List<Consultation> getConsultationByPatient(Patient patient) {
		 //TODO Auto-generated method stub
		List<Consultation> consu = consultationDAO.findByPatient(patient);
		if(!consu.isEmpty()) {
			return consu;
		}
		return null;
	}

	@Override
	public List<Consultation> getConsultationByIdRdv(RendezVous rendezVous) {
		//TODO Auto-generated method stub
				List<Consultation> rdv = consultationDAO.findByIdRdv(rendezVous);
				if(!rdv.isEmpty()) {
					return rdv;
				}
				return null;
			}
		
}
