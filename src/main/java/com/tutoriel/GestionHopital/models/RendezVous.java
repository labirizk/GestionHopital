package com.tutoriel.GestionHopital.models;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RendezVous")
public class RendezVous implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRdv;
	
	@Column(name = "Date")
	private LocalDate Date;
	@Column(name = "AdresseRdv")
	private String AdresseRdv;


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id",referencedColumnName = "id")
	private Medecin medecin;
	
	@ManyToOne
	@JoinColumn(name = "idPatient",referencedColumnName = "id")
	private Patient patient;
	

	@OneToOne 
	private Consultation consultation;
	
	
	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public RendezVous() {
		
	}



	public RendezVous(Long idRdv, LocalDate date, String adresseRdv, Medecin medecin, Patient patient,
			Consultation consultation) {
		this.idRdv = idRdv;
		this.Date = date;
		this.AdresseRdv = adresseRdv;
		this.medecin = medecin;
		this.patient = patient;
		this.consultation = consultation;
	}

	public Long getIdRdv() {
		return idRdv;
	}


	public void setIdRdv(Long idRdv) {
		this.idRdv = idRdv;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		this.Date = date;
	}


	public String getAdresseRdv() {
		return AdresseRdv;
	}


	public void setAdresseRdv(String adresseRdv) {
		AdresseRdv = adresseRdv;
	}


}

