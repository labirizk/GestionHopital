package com.tutoriel.GestionHopital.models;

import java.util.Collection; 

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatient;
	@Column(name = "NomPatient")
	private String NomPatient;
	@Column(name = "NumSecu")
	private Long NumSecu;
	
	
	@OneToMany(mappedBy = "Patient", fetch = FetchType.LAZY)
	private Collection<RendezVous> lesRendezVous;
	 
	@JsonIgnore
	public Collection<RendezVous> getLezRendezVous() {
		return lesRendezVous;
	}
	
	
	
	public Patient() {	
	}

	public Patient(String nomPatient, Long numSecu) {
	
		this.NomPatient = nomPatient;
		this.NumSecu = numSecu;
	}

	public Long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}
	public String getNomPatient() {
		return NomPatient;
	}
	public void setNomPatient(String nomPatient) {
		this.NomPatient = nomPatient;
	}
	public Long getNumSecu() {
		return NumSecu;
	}
	public void setNumSecu(Long numSecu) {
		this.NumSecu = numSecu;
	}
	
}
